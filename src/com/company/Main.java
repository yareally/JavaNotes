package com.company;

import com.company.collectionExamples.Queues;
import com.company.inheritance.childClasses.Mammal;
import com.company.inheritance.childClasses.birds.Hawk;
import com.company.inheritance.interfaces.AnimalInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Useful intellij idea commands
 *
 * command + d = duplicate current line cursor is on
 * ctrl + q = display documentation for whatever the cursor is currently on
 * ctrl + p = bring up parameter list for the method the cursor is on
 * ctrl + alt + l = reformat current file
 * ctrl + left click = go to implementation of the method/variable/class/object you left clicked on
 *
 * ctrl + t = update code from remote git repo
 * ctrl + k = commit your code to local git repo
 * ctrl + shift + k = push your code to remote git repo
 *
 * shift + f6 = rename whatever the cursor is on
 * ctrl + enter = finish the line you are currently tying out. this will add closing ), } and ; if needed
 *
 * alt + enter = brings up a fix menu for whatever your cursor is on.
 * Will give auto fixes for errors or warnings if possible (this is also the menu that pops up when clicking on the light bulb
 *
 * When in doubt on what to do, type the variable and a . to bring up all the methods you can do on a variable. Then read through the documentation for each.
 */
public class Main
{

    public static void main(String[] args)
    {

        // you can either define this as
        // ArrayList<String> stringList = new ArrayList<>();
        // or use "var" to cut down on code (in java 9 and above)
        var stringList = new ArrayList<String>();
        stringList.add("item");

        // create a list, add some animals to a list
        // lists can be resized
        var animals = new ArrayList<AnimalInterface>();
        // add a default mammal
        animals.add(new Mammal());
        // add a mammal with an age of 3
        animals.add(new Mammal(3));
        // also add a hawk, because it also implements the AnimalInterface like Mammal does:
        animals.add(new Hawk());

        // this is equivalent to the list above, but more concise:
        var moreAnimals = List.of(new Mammal(), new Mammal(3), new Hawk());
        // ----------INHERITANCE / POLYMORPHISM / COMPOSITION
        // you could also define the animals as variables and add them to a list:
        // equivalent to the above lists, but with named variables added instead of anonymous ones:

        // same as animals.add(new Mammal());
        var animal = new Mammal();
        animals.add(animal);
        // same as animals.add(new Mammal(3));
        var threeYearOldAnimal = new Mammal(3);
        animals.add(threeYearOldAnimal);
        // same as animals.add(new Hawk());
        var hawk = new Hawk();
        animals.add(hawk);

        // create an array of strings that holds 10 strings
        // arrays cannot be resized. You have to copy the items in the array to a larger array
        // cannot remove items from an array, must copy them to a new array
        var arrayOfStrings = new String[10];
        arrayOfStrings[0] = "test";
        arrayOfStrings[1] = "test 2";
        arrayOfStrings[2] = "test 3";
        // this is equivalent to the above string array, but more concise:
        String[] anotherArrayOfStrings = {"test", "test 2", "test 3"};

        // create a bear without setting age
        // all objects are created in the form of the following:
        // ClassName variableName = new ClassName();
        // Classname is the name of the class/interface for the object you wish to create
        // variable name is whatever you want to call your object
        // new tells the compiler that you are creating an object
        var bear = new Mammal();
        // create ape with setting its age
        var ape = new Mammal(1);

        System.out.println("bear age: " + bear.getAge());
        System.out.println("ape age: " + ape.getAge());

        bear = ape; // points bear to the ape object (if you modify bear, it will now modify ape and vice versa)

        // bear and ape are now the same object and modifying one modifies the other
        System.out.println("bear age (after bear = ape): " + bear.getAge());
        System.out.println("ape age (after bear = ape): " + ape.getAge());

        ape.setAge(10);

        System.out.println("bear age (after ape age set to 10): " + bear.getAge());
        System.out.println("ape age (after ape age set to 10): " + ape.getAge());

        bear.setAge(10);

        System.out.println("bear age (after bear age set to 10): " + bear.getAge());
        System.out.println("ape age (after bear age set to 10): " + ape.getAge());

        // ------------- STRINGS -------------------
        // these are the same
        var string = "test";
        var string2 = new String("test");
        var string3 = string2; // creates a copy of the string
        string2 = ""; // string3 is not modified because it's a copy (unlike bear and ape in the example above)

        System.out.println(string2);
        System.out.println(string3);

        // these are the same, but different ways to concatenate a string
        string = string + "another string";
        string2 += "another string";
        string = string.concat("another string");
        // this uses a custom method we defined near the end of the file to concatenate 2 strings:
        string = concatStrings(string, "another string");

        // reset the value for examples below
        string = "test";

        // -------- CONDITIONAL STATEMENTS (if/else if/ else / switch)
        if (string.equals(string2) || string.equals(string3)) {
            // do stuff if string equals string2 or string equals string3
        }
        else if (string2.equals(string3)) {
            // do stuff if string2 equals string3
        }
        else {
            // if string, string2 and string 3 are not equal at all do this
        }

        if (string.equals(string2) && string2.equals(string3)) {
            // do stuff if string equals string2 and string2 equals string3
        }


        if (string.equals("test")) {
            // do something if string is equal to "test"
        }
        else if (string.equals("test 2")) {
            // do something if string is equal to "test 2"
        }
        else {
            // do something if it's not equal to "test" or "test 2"
        }

        // this is the same as the if/else below it
        var result = string.equals("test") // the condition to compare
            ? "matches" // the if part
            : "does not match"; // the else part
        var result2 = "";

        if (string.equals("test")) {
            result2 = "matches";
        }
        else {
            result2 = "does not match";
        }

        // this is equivalent to the if/else right above
        switch (string) {
            case "test":
                System.out.println("test match");
                // do something if string is equal to "test"
                break;
            case "test 2":
                System.out.println("test 2");
                // do something if string is equal to "test 2"
                break;
            default:
                System.out.println("default, no match");
                // do something if it's not equal to "test" or "test 2"
        }


        switch (string) {
            case "test":
                System.out.println("case test");
                // do something if string is equal to "test"
                // since there's no break below, this will also run whatever is in case "test 2"
                // regardless of whether it matches "test 2" or not
            case "test 2":
                System.out.println("test 2");
                // do something if string is equal to "test 2"
                break;
            default:
                System.out.println("default, no match");
                // do something if it's not equal to "test" or "test 2"
        }

        // -------- LOOPS -------------------
        // use the method we created below to return a list of strings
        ArrayList<String> list = createList();

        // loop through the list and print each string
        for (String item : list) {
            System.out.println("current item: " + item);
        }

        // loop through the list in another way:
        // variables defined outside of the loop can be used inside the loop and after the end of the loop (after the {} )
        // variables defined within the loop cannot be used outside of the loop (after the {} )
        for (var i = 0; i < list.size(); i++) {
            // this will get the item from the previous iteration of the loop
            String lastItem = i == 0 ? list.get(0) : list.get(i - 1);
            // this will print the previous item
            System.out.println("previous item: " + lastItem);
            // this will print the current item
            System.out.println("current item: " + list.get(i));
        }

        // loop through the list in yet another way:
        int i = 0;
        while (i < list.size()) {
            System.out.println("current item: " + list.get(i));
            i++;
        }
        // ---------------------------------------------------------
        // loop through yet another way (though not suggested for this example)
        // because a do/while loop will always execute what is within the loop at least once
        // even if the while condition is initially false
        // why is this bad? Because if the list is empty, it's going to throw an error trying to print the first element

        int j = 0;
        do {
            System.out.println("current item: " + j);
            j++;
        } while (j < list.size()); // requires a semi colon at the end, unlike other loops above

        var queues = new Queues();
        queues.priorityQueue();



        // in class examples:

        // reverse an array:

        // we want to reverse the values in reverseMe by storing them in reversed
        int[] reverseMe = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // we want to store the reversed array in reversed
        int[] reversed = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        // if not using a loop, you would have to do something like this:
        // what in these 3 lines takes the place of our index counter in our loop?
        // reversed[0] = reverseMe[reverseMe.length - 1]; // puts the 10 in the 0 position of reversed
        // reversed[1] = reverseMe[reverseMe.length - 2]; // puts the 9 in the 1 position of reversed
        // reversed[2] = reverseMe[reverseMe.length - 3];

        for (int index = 0; index < reverseMe.length; index++) {
            reversed[index] = reverseMe[reverseMe.length - (index + 1)];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        // elements in sets must be unique. Adding another element to a set with the same data will replace the previous data instead of adding 2 elements with the same data
        set1.add(1);
        set1.add(2);
        set1.add(2);
        set1.add(3);
        set1.add(5);
        set1.add(8);
        set1.add(13);
        set1.add(30);
        set1.add(60);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(3);
        set2.add(5);
        set2.add(8);
        set2.add(13);
        set2.add(21);
        set2.add(34);

        set1.retainAll(set2);
        set1.addAll(set2);

        var matrix = new int[5][5];
        for (int index = 0; i < matrix.length; index++) {
            for (int count = 0; count < matrix.length; count++) {
                matrix[index][count] = 0;
            }
        }
        var middleElement = matrix[2][2];

    }

    // -------- RETURNING THINGS FROM METHODS ---------

    public static String concatStrings(String a, String b)
    {
        // all methods in the main class have to have static on them, because the main method has static on it
        // you could do this:
        // String result = a + b;
        // return result;

        // however, this is more concise:
        return a + b;
    }

    public static ArrayList<String> createList()
    {
        // let's create a list and then return it for use elsewhere
        var list = new ArrayList<String>();
        list.add("item");
        list.add("another item");
        list.add("yet another item");

        return list;
    }
}
