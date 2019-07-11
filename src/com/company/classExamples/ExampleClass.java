package com.company.classExamples;

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

    // this is a static string. That means that all objects created from this class (class Main) will all
    // share the same instance of the oneInstance variable. Usually this isn't a good idea and only has a few use cases.
    // Why? Because modifying oneInstance in one object that contains it, will also modify it in all other objects that contain it.
    // However, there is only ever one instance of a main class, so it's okay to do this here and the only way to define class variables in the main class
    private static String oneInstance = "there can only be one";
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
     * Default constructors are automatically generated if you do not add one to a class. The only reason to manually add one
     * (like below) is if you need to initialize some variables or other data before using the class.
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
