package com.company.inheritance.interfaces;

/**
 * @author Wes Lanning
 * @version 2019-07-10
 */
public interface Organism {
    int getCurrentHitPoints();
    int getMaxHitPoints();
    int getExperiencePoints();
    int getNextLevelExperiencePoints();
    int getCurrentLevel();
    int getAge();

    void setCurrentHitPoints(int hitPoints);
    void setMaxHitPoints(int maxHitPoints);
    void setExperiencePoints(int experiencePoints);
    void setNextLevelExperiencePoints(int nextLevelExperiencePoints);
    void setCurrentLevel(int currentLevel);
    void setAge(int ageInYears);
    void grow(Food food);
}
