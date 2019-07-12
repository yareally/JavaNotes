package com.company.classExamples;

import com.company.inheritance.childClasses.Mammal;

import java.util.ArrayList;

/**
 * @author Wes Lanning
 * @version 2019-07-11
 */
public class ExampleClass
{
    // this is a class variable that is defined as being constant (can never change)
    // any class variable with static + final on it is a constant in java
    private static final String constant = "this will never change";

    // this is a static string. That means that all objects created from this class (class ExampleClass) will all share the same instance of the oneInstance variable.
    private static String oneInstance = "there can only be one";
    // Usually this isn't a good idea and only has a few use cases.
    // Why? Because modifying oneInstance in one object that contains it, will also modify it in all other objects that contain it.

    // Why do we make everything static in the main class though?
    // Because there is only 1 instance ever of the main class, so it's okay to do this.
    // It's also the only way to define class wide variables or methods in the main class

    // public access means that you can access this variable from anywhere you are using an instance of ExampleClass
    public String message = "";
    // private means that you can only access id from within the ExampleClass. In order to use it elsewhere, you would have to make a getter and a setter
    // e.g. public int getId() {...} and public void setId(int id) {...} (see getter/setter below)
    private int id = 0;

    // protected means that you can access this variable from within ExampleClass or any class that inherits (extends) ExampleClass
    protected String name = "";

    // final means that this value is read only once it's initialized.
    // class variables defined as final can only be initialized in a constructor or inline where the variable is defined.
    // ex: protected final String notes = "some notes here"
    protected final String notes;

    private ArrayList<String> list;

    /**
     * This is a default constructor. A default constructor has no parameters/arguments. If there is nothing in
     * the () like below for ExampleClass(), then there are no parameters and it's a default constructor.
     *
     * Default constructors are automatically generated if you do not add a constructor to a class.
     * However, if a constructor with parameters is added, then you must manually add a default constructor if you want to create an object that has no parameters.
     * Although a default constructor takes no parameters, it can still initialize variables and other data important to the class (like below).
     *
     * ExampleClass is also the return type (because when we call this constructor to create an ExampleClass object, it returns a new instance of an ExampleClass
     */
    public ExampleClass()
    {
        // because notes is read only once it's set in the constructor, it must be defined in all constructors in the class
        notes = "";
        // populate the array list with some strings
        list = createList();
    }

    public ExampleClass(String message, String notes, int ident)
    {
        // "this" is required in front of message, because the parameter message has the same name as the class variable called message
        // "this" refers to the class variable message while not putting "this" in front of the parameter denotes you are referring to the parameter and not the class variable
        this.message = message;
        // set the read only value here
        this.notes = notes;
        // because id and ident are not the same name, "this" is not required in front of id
        id = ident;
        // populate the array list with some strings
        list = createList();

        // creates a bear mammal object with an age of 3
        Mammal bear = createMammal(3);
        // call a static method (a method we can use without creating an instance of the object it resides in)
        String mammalSound = Mammal.makeNoise();
        // the following 2 lines do the same thing:
        System.out.println(mammalSound);
        System.out.println(Mammal.makeNoise());
    }



    // static on a method is not quite the same as static on a class variable. There is only one instance of the method like there is for class variables.
    // However, the a static method is self-contained and will not cause side effects when used, unlike a static class variable.
    // Static methods do not require an object type of the class they're contained in to be invoked/executed.
    // This is because memory for them is allocated ahead of time.
    // You can invoke a static method like this: ExampleClass.createList();
    public static ArrayList<String> createList()
    {
        // let's create a list and then return it for use elsewhere
        var list = new ArrayList<String>();
        list.add("item");
        list.add("another item");
        list.add("yet another item");

        return list;
    }

    public void returnsNothing(int someValue, String[] stringArray)
    {
        someValue++; // this also does nothing, because someValue is passed by value and not by reference
        // In other words, it creates a copy when passed by value.
        // However, it points to the original variable where you called this method if the variable is passed as a reference to the original
        // Anything other than int, short, float, long, double, string, boolean, enum is passed by reference
        // Basically that means any collection, java provided classes/objects and your own classes/objects are all passed by reference
        // Thus, be careful about modifying them in methods you pass anything by reference to, because it could cause unintended side effects

        // since arrays are passed by reference, this will also affect the array after returning back to where we called this method.
        // this will wipe out whatever was in position 0:
        stringArray[0] = "";

        // Since java does create a copy of the reference when passing the variable to a method, you can point the copied reference to a new reference to get around this issue like so:
        stringArray = new String[5];
        // the above line will point the copied reference to a new place in memory and thus no longer affect the original array passed into this method

        // The line below will not affect the original array since we pointed the copied reference to a new array in memory.
        stringArray[1] = "";

        // This function returns nothing because the return type is void
        // In other words, there's a hidden implied return; statement at the end of void methods
    }

    public Mammal createMammal(int age) {
        // you can return any object type from a function, but it has to be declared as the return type in order to return it
        // this returns a new mammal with the given age passed in as a parameter.
        return new Mammal(age);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }
}
