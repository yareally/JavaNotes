package com.company.inheritance.childClasses;

import com.company.inheritance.interfaces.Predator;
import com.company.inheritance.interfaces.Prey;
import com.company.inheritance.parentClasses.Plant;
import com.company.util.Helpers;

/**
 * This class extends Plant instead of implementing the interfaces like the animal classes.
 * The drawback of this is that it's more tightly coupled to the parent class (Plant).
 * This makes it harder to change the implementation of grass because it is required to
 * implement everything in the parent Plant class, even if it doesn't require it.
 *
 * Unlike the child animal classes that implement multiple interfaces, you can only
 * extend one parent class in the child classes.
 *
 * @author Wes Lanning
 * @version 2019-07-10
 */
public class Grass extends Plant implements Prey {

    public Grass()
    {
        maxHitPoints = 10;
        currentHitPoints = maxHitPoints;
        nextLevelExperiencePoints = 50;
    }

    @Override
    public int giveHitPoints() {
        // we are overriding (reimplementing the method) because the default
        // hit points given for eating grass were a bit too high
        return (int) (maxHitPoints * Helpers.getRandom(.1, .5));
    }

    @Override
    public void defend(Predator attacker) {
        attacker.attack(this);
        // grass can't attack, so don't do anything else
    }
}
