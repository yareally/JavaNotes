package com.company.interfaces;

/**
 * @author Wes Lanning
 * @version 2019-07-10
 */
public interface Predator extends Organism
{
    void attack(Prey defender);
}
