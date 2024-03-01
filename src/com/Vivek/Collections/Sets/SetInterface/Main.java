package com.Vivek.Collections.Sets.SetInterface;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // As the name suggests, it contains unique values as it is a set, and they can be in any
        // order as they implement using Hashing.
        // Used for the case where we need search, insert, deletion efficient.
        Set<Integer> set = new HashSet<>();

        // set.add() returns boolean, to say if element was successfully added or not.
        System.out.println(set.add(20));
        System.out.println(set.add(10));
        System.out.println(set.add(40));
        System.out.println(set.add(80));
        System.out.println(set.add(20));

        System.out.println(set);

        System.out.println("<<<<<<<<< Linked HashSet >>>>>>>>");
        // Linked HashSet maintains the insertion order.
        Set<Integer> setTwo = new LinkedHashSet<>();
        System.out.println(setTwo.add(20));
        System.out.println(setTwo.add(10));
        System.out.println(setTwo.add(40));
        System.out.println(setTwo.add(80));
        System.out.println(setTwo.add(20));

        System.out.println(setTwo);

        System.out.println("<<<<<<<< TreeSet >>>>>>>>");
        Set<Integer> setThree = new TreeSet<>();
        // TreeSet is implement using self-balancing binary tree like red-black tree.
        // So the item will be stored in a sorted order.
        // Here, we implemented TreeSet using wrapper class Integer, if you have your own type
        // you will need to pass comparator operator in TreeSet<>(Comparator);

        // User where we need some order, finding ceil, floor.
        System.out.println(setThree.add(20));
        System.out.println(setThree.add(10));
        System.out.println(setThree.add(40));
        System.out.println(setThree.add(80));
        System.out.println(setThree.add(20));

        System.out.println(setThree);
    }
}
