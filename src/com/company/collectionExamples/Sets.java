package com.company.collectionExamples;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wes Lanning
 * @version 2019-07-11
 */
public class Sets
{

    public void doStuff() {
        Set<Integer > set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        // elements in sets must be unique. Adding another element to a set with the same data will replace the previous data instead of adding 2 elements with the same data
        set1.add(1);
        set1.add(2);
        set1.add(2);
        set1.add(3);
        set1.add(5);
        set1.add(8);
        set1.add(13);
        set1.add(30);
        set1.add(60);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(3);
        set2.add(5);
        set2.add(8);
        set2.add(13);
        set2.add(21);
        set2.add(34);

        // performs the intersection of set1 and set2 (aka set1 AND set2)
        set1.retainAll(set2);
    }
}
