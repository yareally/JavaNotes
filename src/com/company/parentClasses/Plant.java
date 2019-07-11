package com.company.parentClasses;

import com.company.interfaces.Food;
import com.company.interfaces.PlantInterface;
import com.company.util.Helpers;

/**
 * @author Wes Lanning
 * @version 2019-07-10
 */
public class Plant implements PlantInterface, Food {

    protected int currentHitPoints = 0;
    protected int maxHitPoints = 0;
    protected int experiencePoints = 0;
    protected int nextLevelExperiencePoints = 100;
    protected int currentLevel              = 1;
    protected int ageInYears              = 0;

    public Plant() {

    }

    @Override
    public void eat(Food food) {
        currentHitPoints = currentHitPoints + food.giveHitPoints() > maxHitPoints
            ? maxHitPoints
            : currentHitPoints + food.giveHitPoints();

        grow(food);
    }

    @Override
    public int giveHitPoints() {
        return maxHitPoints;
    }

    @Override
    public int giveExperiencePoints() {
        return experiencePoints * currentLevel;
    }

    @Override
    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    @Override
    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    @Override
    public int getExperiencePoints() {
        return experiencePoints;
    }

    @Override
    public int getNextLevelExperiencePoints() {
        return nextLevelExperiencePoints;
    }

    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public int getAge() {
        return ageInYears;
    }

    @Override
    public void setCurrentHitPoints(int hitPoints) {
        currentHitPoints = hitPoints;
    }

    @Override
    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    @Override
    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    @Override
    public void setNextLevelExperiencePoints(int nextLevelExperiencePoints) {
        this.nextLevelExperiencePoints = nextLevelExperiencePoints;
    }

    @Override
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    @Override
    public void setAge(int ageInYears) {
        this.ageInYears = ageInYears;
    }

    @Override
    public void grow(Food food) {
        experiencePoints += food.giveExperiencePoints();

        if (experiencePoints >= nextLevelExperiencePoints) {
            currentLevel += 1;
            maxHitPoints += maxHitPoints * Helpers.getRandom(0.1, 0.4);
            currentHitPoints = maxHitPoints;
            nextLevelExperiencePoints += (experiencePoints / currentLevel);
        }
    }
}
