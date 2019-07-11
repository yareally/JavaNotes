package com.company.inheritance.childClasses;

import com.company.inheritance.interfaces.AnimalInterface;
import com.company.inheritance.interfaces.Food;
import com.company.inheritance.parentClasses.Animal;

/**
 * @author Wes Lanning
 * @version 2019-07-10
 */
public class Mammal implements AnimalInterface, Food {

    private Animal mammal;

    public Mammal() {
        mammal = new Animal();
    }

    public Mammal(int age)
    {
        this(); // calls the empty constructor (i.e. Mammal() )
        mammal.setAge(age);
    }

    @Override
    public void sleep() {
        mammal.sleep();
    }

    @Override
    public void eat(Food food) {
        mammal.eat(food);
    }

    @Override
    public int giveHitPoints() {
        return mammal.giveHitPoints();
    }

    @Override
    public int giveExperiencePoints() {
        return mammal.giveExperiencePoints();
    }

    @Override
    public int getCurrentHitPoints() {
        return mammal.getCurrentHitPoints();
    }

    @Override
    public int getMaxHitPoints() {
        return mammal.getMaxHitPoints();
    }

    @Override
    public int getExperiencePoints() {
        return mammal.getExperiencePoints();
    }

    @Override
    public int getNextLevelExperiencePoints() {
        return mammal.getNextLevelExperiencePoints();
    }

    @Override
    public int getCurrentLevel() {
        return mammal.getCurrentLevel();
    }

    @Override
    public int getAge() {
        return mammal.getAge();
    }

    @Override
    public void setCurrentHitPoints(int hitPoints) {
        mammal.setCurrentHitPoints(hitPoints);
    }

    @Override
    public void setMaxHitPoints(int maxHitPoints) {
        mammal.setMaxHitPoints(maxHitPoints);
    }

    @Override
    public void setExperiencePoints(int experiencePoints) {
        mammal.setExperiencePoints(experiencePoints);
    }

    @Override
    public void setNextLevelExperiencePoints(int nextLevelExperiencePoints) {
        mammal.setNextLevelExperiencePoints(nextLevelExperiencePoints);
    }

    @Override
    public void setCurrentLevel(int currentLevel) {
        mammal.setCurrentLevel(currentLevel);
    }

    @Override
    public void setAge(int ageInYears) {
        mammal.setAge(ageInYears);
    }

    @Override
    public void grow(Food food) {
        mammal.grow(food);
    }

    /**
     * This is a static method. We can call this from anywhere without creating an instance of mammal first.
     * Static methods can only use other methods or variables that are also marked as static.
     * Variables and methods not marked as static are called instance methods and variables. Because they require
     * an instance of the class object they reside in to be created before used.
     *
     * Why not make every method static? Because static methods cannot be inherited, overridden or implemented from an interface.
     * Thus, they are not very reusable.
     *
     * However, if a method is self contained and does not need to ever be inherited, overridden or implemented from an interface, then making it static is okay.
     * @see com.company.util.Helpers for examples of good static method usage.
     *
     * Examples of static methods built into java are System.out.println("") and System.out.print("")
     *
     * @see com.company.classExamples.ExampleClass for static method usage.
     * @return some random sound a mammal might make
     */
    public static String makeNoise()
    {
        return "bark bark";
    }
}
