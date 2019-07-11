package com.company.inheritance.childClasses.birds;

import com.company.inheritance.childClasses.Bird;
import com.company.inheritance.interfaces.Predator;
import com.company.inheritance.interfaces.Prey;

/**
 * @author Wes Lanning
 * @version 2019-07-10
 */
public class Hawk extends Bird implements Predator {


    @Override
    public void fly() {

    }

    @Override
    public void attack(Prey defender) {

    }
}
