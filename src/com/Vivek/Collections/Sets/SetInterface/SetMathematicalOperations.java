package com.Vivek.Collections.Sets.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class SetMathematicalOperations {
    public static void main(String[] args) {
        Set<Integer> setOne = new HashSet<>();
        System.out.println(setOne.add(10));
        System.out.println(setOne.add(20));
        System.out.println(setOne.add(40));
        System.out.println(setOne.add(100));

        System.out.println("<< SetOne >> :\n" + setOne);

        Set<Integer> setTwo = new HashSet<>();
        System.out.println(setTwo.add(30));
        System.out.println(setTwo.add(50));
        System.out.println(setTwo.add(40));
        System.out.println(setTwo.add(100));

        System.out.println("<< SetTwo >> :\n" + setTwo);

        // Union
        System.out.println("<< Union >>");
        setOne.addAll(setTwo);
        System.out.println("<< SetOne becomes >> \n" + setOne);

        // Intersection
        Set<Integer> set1 = new HashSet<>();
        set1.add(2); set1.add(4); set1.add(10);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2); set2.add(6); set2.add(10);
        System.out.println("<< Intersection >>");
        set1.retainAll(set2);
        System.out.println("<< Set1 becomes >> \n" + set1);

        // Difference
        // It will remove all the item all set4 which are present in set3
        Set<Integer> set3 = new HashSet<>();
        set3.add(2); set3.add(4); set3.add(10);

        Set<Integer> set4 = new HashSet<>();
        set4.add(2); set4.add(6); set4.add(10);
        System.out.println("<< Difference >>");
        set3.removeAll(set4);
        System.out.println("<< Set1 becomes >> \n" + set3);
    }
}
