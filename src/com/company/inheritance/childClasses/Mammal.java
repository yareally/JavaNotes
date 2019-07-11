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
}
