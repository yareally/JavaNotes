package com.company.collectionExamples;

import com.company.inheritance.childClasses.Mammal;
import com.company.inheritance.childClasses.birds.Hawk;
import com.company.inheritance.interfaces.AnimalInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps are a collection of unique keys where each key points to a non-unique value. A real life example of a map
 * would be a dictionary. A dictionary is composed of unique words (which are keys) and each word points to a definition (the value).
 *
 * Another example would be hotel rooms. Each room has a unique number. By knowing the room number, you can find the room (the value).
 *
 * @author Wes Lanning
 * @version 2019-07-11
 */
public class Maps
{
    // create a map with some initial values (this way only works in java 9 and above)
    private Map<String, String>              map  = Map.of("key", "value", "anotherKey", "anotherValue");
    // map2 and map3 are the same as a hash map implements the Map interface (so you can refer to it as either a Map or HashMap)
    private Map<String, String>              map2 = new HashMap<>();
    private HashMap<String, AnimalInterface> map3 = new HashMap<>();

    public void UseMap()
    {
        // the following 2 lines make map2 equal to map as we put the same key/values into map2 as we have in map
        map2.put("key", "value");
        map2.put("anotherKey", "anotherValue");

        // we put our own custom created class objects into map3
        map3.put("bear", new Mammal());
        map3.put("red-tailed", new Hawk(7));

        // this will ignore adding this key/value because we already added it
        map3.putIfAbsent("bear", new Mammal());

        // this will overwrite the current bear key/value with a new value. That is the difference between put and putIfAbsent
        map3.put("bear", new Mammal(3));

        // gets the animal object for the key "bear"
        AnimalInterface bear = map3.get("bear");

        // remove the hawk from the hashMap
        Hawk hawk = (Hawk) map3.remove("red-tailed");

        // loop through each key/value pair in the hashmap
        for (var animal : map3.entrySet()) {
            System.out.println("Animal key: " + animal.getKey());
            System.out.println("Animal age: " + animal.getValue().getAge());
        }
    }

}
