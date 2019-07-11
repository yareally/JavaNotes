package com.company.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Wes Lanning
 * @version 2019-07-10
 */
public final class Helpers {

    /**
     * Creates a random between min (inclusive) and max (inclusive)
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max)
    {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Creates a random between 1 (inclusive) and max (inclusive)
     *
     * @param max
     * @return
     */
    public static int getRandom(int max) {
        return getRandom(1, max);
    }

    /**
     * Creates a random between min (inclusive) and max (exclusive)
     *
     * @param min
     * @param max
     * @return
     */
    public static double getRandom(double min, double max)
    {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }
}
