package com.Vivek.Collections.Sets.LinkedHashSet;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // LinkedHashSet is child class of HashSet.
        // LinkedHashSet internally implements doubly linked list.
        // Which is why, it is able to maintain the order in which the items are inserted.
        // This is the only advantage over HashSet.

        // Time complexity is same as HashSet:
        // add(), contains() are O(1) operation on average.
        // size(), isEmpty() are O(1) operation.

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        System.out.println(linkedHashSet.add(10));
        System.out.println(linkedHashSet.add(20));
        System.out.println(linkedHashSet.add(40));
        System.out.println(linkedHashSet.add(80));
        System.out.println(linkedHashSet.add(80));
        System.out.println(linkedHashSet.add(10));

        for(Integer i : linkedHashSet)
            System.out.print(i + " ");
    }
}
