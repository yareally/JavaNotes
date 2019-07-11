package com.company;

import com.company.childClasses.Mammal;
import com.company.childClasses.birds.Hawk;
import com.company.interfaces.AnimalInterface;
import com.company.parentClasses.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("item");

        // create a list, add some animals to a list
        // lists can be resized
        List<AnimalInterface> animals = new ArrayList<>();
        // add a default mammal
        animals.add(new Mammal());
        // add a mammal with an age of 3
        animals.add(new Mammal(3));
        // also add a hawk, because it also implements the AnimalInterface like Mammal does:
        animals.add(new Hawk());

        // this is equivalent to the list above, but more concise:
        List<AnimalInterface> moreAnimals = List.of(new Mammal(), new Mammal(3), new Hawk());
        // -----------------------------------------------
        // you could also define the animals as variables and add them to a list:
        // equivalent to the above lists, but with named variables added instead of anonymous ones:

        // same as animals.add(new Mammal());
        Mammal animal = new Mammal();
        animals.add(animal);
        // same as animals.add(new Mammal(3));
        Mammal threeYearOldAnimal = new Mammal(3);
        animals.add(threeYearOldAnimal);
        // same as animals.add(new Hawk());
        Hawk hawk = new Hawk();
        animals.add(hawk);

        // create an array of strings that holds 10 strings
        // arrays cannot be resized. You have to copy the items in the array to a larger array
        // cannot remove items from an array, must copy them to a new array
        String[] arrayOfStrings = new String[10];
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
        Mammal bear = new Mammal();
        // create ape with setting its age
        Mammal ape = new Mammal(1);

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

        // these are the same
        String string = "test";
        String string2 = new String("test");
        String string3 = string2; // creates a copy of the string
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

        // use the method we created below to return a list of strings
        ArrayList<String> list = createList();

        // loop through the list and print each string
        for (String item : list) {
            System.out.println("current item: " + item);
        }

        // loop through the list in another way:
        // variables defined outside of the loop can be used inside the loop and after the end of the loop (after the {} )
        // variables defined within the loop cannot be used outside of the loop (after the {} )
        for (int i = 0; i < list.size(); i++) {
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
    }


    public static String concatStrings(String a, String b) {
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
        ArrayList<String> list = new ArrayList<>();
        list.add("item");
        list.add("another item");
        list.add("yet another item");

        return list;
    }
}
