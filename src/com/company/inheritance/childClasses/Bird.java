package com.company.inheritance.childClasses;

import com.company.inheritance.interfaces.AnimalInterface;
import com.company.inheritance.interfaces.Food;
import com.company.inheritance.parentClasses.Animal;

/**
 * For the animal classes, we are inheriting the functionality of the parent class by
 * implementing the interfaces used in the parent class and creating an instance of the parent
 * Animal class object to be used in each of the child animal classes (, fish, bird, etc).
 *
 * This allows each child animal class to not be tightly coupled to the parent animal class.
 * Thus, you can easily swap out functionality within each animal class and also implement multiple interfaces.
 *
 *
 * @author Wes Lanning
 * @version 2019-07-10
 */
public abstract class Bird implements AnimalInterface, Food {

    private Animal bird;

    public Bird ()
    {
         bird = new Animal();
    }

    @Override
    public void sleep() {
        bird.sleep();
    }

    @Override
    public void eat(Food food) {
        bird.eat(food);
    }

    @Override
    public int giveHitPoints() {
        return bird.giveExperiencePoints();
    }

    @Override
    public int giveExperiencePoints() {
        return bird.giveExperiencePoints();
    }

    @Override
    public void grow(Food food) {
        bird.grow(food);
    }

    @Override
    public int getCurrentHitPoints() {
        return bird.getCurrentHitPoints();
    }

    @Override
    public int getMaxHitPoints() {
        return bird.getMaxHitPoints();
    }

    @Override
    public int getExperiencePoints() {
        return bird.getExperiencePoints();
    }

    @Override
    public int getNextLevelExperiencePoints() {
        return bird.getNextLevelExperiencePoints();
    }

    @Override
    public int getCurrentLevel() {
        return bird.getCurrentLevel();
    }

    @Override
    public int getAge() {
        return bird.getAge();
    }

    @Override
    public void setCurrentHitPoints(int hitPoints) {
        bird.setCurrentHitPoints(hitPoints);
    }

    @Override
    public void setMaxHitPoints(int maxHitPoints) {
        bird.setMaxHitPoints(maxHitPoints);
    }

    @Override
    public void setExperiencePoints(int experiencePoints) {
        bird.setExperiencePoints(experiencePoints);
    }

    @Override
    public void setNextLevelExperiencePoints(int nextLevelExperiencePoints) {
        bird.setNextLevelExperiencePoints(nextLevelExperiencePoints);
    }

    @Override
    public void setCurrentLevel(int currentLevel) {
        bird.setCurrentLevel(currentLevel);
    }

    @Override
    public void setAge(int ageInYears) {
        bird.setAge(ageInYears);
    }

    public abstract void fly();
}
