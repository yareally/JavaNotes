package com.company.inheritance.childClasses;

import com.company.inheritance.interfaces.AnimalInterface;
import com.company.inheritance.interfaces.Food;
import com.company.inheritance.parentClasses.Animal;

/**
 * @author Wes Lanning
 * @version 2019-07-10
 */
public abstract class Fish implements AnimalInterface, Food {

    private Animal fish;

    public Fish()
    {
        fish = new Animal();
    }

    @Override
    public void sleep() {

    }

    @Override
    public void eat(Food food) {

    }

    @Override
    public int giveHitPoints() {
        return 0;
    }

    @Override
    public int giveExperiencePoints() {
        return 0;
    }

    @Override
    public void grow(Food food) {

    }

    @Override
    public int getCurrentHitPoints() {
        return fish.getCurrentHitPoints();
    }

    @Override
    public int getMaxHitPoints() {
        return fish.getMaxHitPoints();
    }

    @Override
    public int getExperiencePoints() {
        return fish.getExperiencePoints();
    }

    @Override
    public int getNextLevelExperiencePoints() {
        return fish.getNextLevelExperiencePoints();
    }

    @Override
    public int getCurrentLevel() {
        return fish.getCurrentLevel();
    }

    @Override
    public int getAge() {
        return fish.getAge();
    }

    @Override
    public void setCurrentHitPoints(int hitPoints) {
        fish.setCurrentHitPoints(hitPoints);
    }

    @Override
    public void setMaxHitPoints(int maxHitPoints) {
        fish.setMaxHitPoints(maxHitPoints);
    }

    @Override
    public void setExperiencePoints(int experiencePoints) {
        fish.setExperiencePoints(experiencePoints);
    }

    @Override
    public void setNextLevelExperiencePoints(int nextLevelExperiencePoints) {
        fish.setNextLevelExperiencePoints(nextLevelExperiencePoints);
    }

    @Override
    public void setCurrentLevel(int currentLevel) {
        fish.setCurrentLevel(currentLevel);
    }

    @Override
    public void setAge(int ageInYears) {
        fish.setAge(ageInYears);
    }


    public abstract void swim();
}
