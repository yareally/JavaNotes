package com.company.collectionExamples;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * Remember that sets and maps are unordered lists.
 * You can only directly access a value from a set if you know the value ahead of time
 *
 * You can only directly access a value from a map if you know the key that points to the value
 *
 * If you don't know either of the above, then you are probably using the wrong collection type.
 *
 * If there's a small chance a set or map is the correct collection, then you would have to loop over the collection
 * to find the value you want by checking each element.
 *
 * @author Wes Lanning
 * @version 2019-07-11
 */
public class EnumSetsAndEnumMaps
{
    // puts all the days into this enum set
    EnumSet<Days> daysOfWeek = EnumSet.allOf(Days.class);
    // puts no days into this enum set
    EnumSet<Days> noDays = EnumSet.noneOf(Days.class);
    // puts monday to friday (inclusive) into this enum set
    EnumSet<Days> weekdays = EnumSet.range(Days.MONDAY, Days.FRIDAY);
    // puts the days of the week not in weekdays into this enum set
    EnumSet<Days> weekends = EnumSet.complementOf(weekdays);

    // when using a collction, you have to put Integer/Long/Boolean/Float/Double instead of int/long/boolean/float/double
    // because Integer is a wrapper object around the primitive type of int. Collections can only store objects, no primitves.
    EnumMap<Days, Integer> map = new EnumMap<>(Days.class);

    public void UseEnumSet()
    {
        System.out.println("daysOfWeek: " + daysOfWeek);
        System.out.println("weekends: " + weekends);
        System.out.println("weekdays: " + weekdays);
        System.out.println("noDays: " + noDays);
        // puts monday into the no days enum set
        noDays.add(Days.MONDAY);
        // removes monday from the no days enum set
        noDays.remove(Days.MONDAY);

        // because tuesday is a weekday, this will print the line in the if statement
        if (weekdays.contains(Days.TUESDAY)) {
            System.out.println("Tuesday is a weekday!");
        }

        // this will also be true and print the statement in the if statement
        if (daysOfWeek.containsAll(weekends)) {
            System.out.println("Saturday and Sunday are days of the week!");
        }
    }

    public void UseEnumMap()
    {
        // add some keys and values to the enum map
        // Days.MONDAY is a key, 1 is a value
        map.put(Days.MONDAY, 1);
        map.put(Days.TUESDAY, 2);
        map.put(Days.WEDNESDAY, 3);
        map.put(Days.THURSDAY, 4);

        // print the map
        for (EnumMap.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        // all collections have a size() method that lets you get the current size of the collection
        System.out.println("Collection size: " + map.size());
    }
}
}

enum Days
{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
