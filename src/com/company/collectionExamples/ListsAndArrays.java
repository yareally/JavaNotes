package com.company.collectionExamples;

import com.company.inheritance.childClasses.Mammal;
import com.company.inheritance.childClasses.birds.Hawk;
import com.company.inheritance.interfaces.AnimalInterface;

import java.util.*;
import java.util.Arrays;

/**
 * ArrayLists are a special type of array that will grow or shrink if you add or remove items from it.
 * It works just like an array (aside from allowing growing and shrinking), but with slightly different syntax.
 * Note that removing/adding items from anywhere other than the start or end of the array list is slightly more costly
 * because it has to copy over all the elements not removed to a new array.
 *
 * However, accessing an element in the middle of the array list to get its value is instant like a normal array
 *
 * If you plan to add/remove a lot of elements from somewhere other than the start/end and do not need to access
 * random elements in the middle based on their index, then a linked list might be a better collection option.
 *
 * You can store any type of object in a collection (including class objects you create yourself)
 *
 * @author Wes Lanning
 * @version 2019-07-11
 */
public class ListsAndArrays
{
    // create a list of strings
    private ArrayList<String> stringList = new ArrayList<>();
    // ArrayList implements the List interface, so it can also declare itself as a List and work the same:
    private List<String> anotherStringList = new ArrayList<>();

    // creates a fixed array of strings with buckets for strings to be stored in (each bucket it initially null)
    private String[] stringArray = new String[10];
    // same as the above stringArray, but more visual:
    private String[] stringArray2 = {null, null, null, null, null, null, null, null, null, null};
    // creates a fixed array with the numbers 1 to 10 in the 10 buckets
    private String[] stringArray3 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public void useArray()
    {
        var stringArray4 = new String[10];

        for (int i = 1; i <= 10; i++) {
            // put 1 to 10 inside the array of strings
            // this will make it equal to stringArray3
            stringArray4[i - 1] = String.valueOf(i);
        }
        // print out whether the value at index 3 in stringArray3 is equal to the value at index 3 in stringArray4
        System.out.println("stringArray3[3].equals(stringArray4[3]): " + stringArray3[3].equals(stringArray4[3]));

        System.out.println("Size of array (stringArray4): " + stringArray4.length);

        // if you want to resize a fixed array, you would have to manually copy all the elements over like so:
        // takes stringArray4 and copies it to a fixed array with 20 buckets of data instead of 10
        var stringArray5 = Arrays.copyOf(stringArray4, 20);
        System.out.println("Size of stringArray5: " + stringArray5.length);

        // convert array to an arrayList
        List<String> arrayToList = Arrays.asList(stringArray4);
        // you can also put your own created objects into fixed arrays:
        var animalArray = new AnimalInterface[10];
        // create a hawk and store it in the 0 position of the fixed array
        animalArray[0] = new Hawk(1);
        // createa a mammal and store it in the last position of the fixed array
        animalArray[9] = new Mammal(4);

    }

    public void useArrayList()
    {
        for (int i = 1; i <= 10; i++) {
            // put 1 to 10 inside the array of strings
            // this will make it equal to stringArray3
            stringList.add(String.valueOf(i));
        }
        // print out whether the value at index 3 in stringArray3 is equal to the value at index 3 in stringList
        System.out.println("stringArray3[3].equals(stringList.get(3)): " + stringArray3[3].equals(stringList.get(3)));

        System.out.println("Size of list (stringList): " + stringList.size());

        // removes the last element of the list:
        stringList.remove(stringList.size() - 1);
        // remove the first element of the list:
        stringList.remove(0);
        System.out.println("Size of stringList: " + stringList.size());

        if (!stringList.isEmpty()) {
            // still has elements in it, so this will print out
            System.out.println("stringList is not empty. It still has " + stringList.size() + " elements in it");
        }

        // This will convert the list to a fixed array
        String[] stringListAsArray = stringList.toArray(new String[0]);

        // print out all the items in the fixed array we converted from a list
        for (String item : stringListAsArray) {
            System.out.println("Next item in stringListAsArray: " + item);
        }

        if (stringList.contains("1")) {
            // if you have to randomly check an array a lot for a value, it's probably best not to use an array
            // why? because behind the scenes it's looping over every position in the array until it finds the value that matches "1"
            // It has to do this because java doesn't know what index the value is at unless you can tell it the position.

            // With a hashset or hashmap, it keeps a reference to the position the value is located for you, but does not keep them in a specific order (unlike a list or array)

            // There is an order set and ordered map, but those are no as efficient as the unordered hashmap and hashset.
            // They do have some use cases though, because they are still faster in some cases than arrays or lists.
        }

        // if you converted this list to a set, it will look up the value in real-time (no loop):
        if (new HashSet<>(stringList).contains("1")) {
            // this will instantly find the value "1" instead of looping over the collection to find it
        }

        // this is the same as writing if (stringList.size() > 0)
        if (!stringList.isEmpty()) {

        }

        // this will change the value at position 2 to "100"
        stringList.set(2, "100");
    }
}
