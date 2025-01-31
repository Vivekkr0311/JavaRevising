package com.Vivek.LeetCode.Collections.Sets.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        // HashSet is used to store keys.
        // It uses Hashing and Hash Table to store these keys.
        // And it uses Hash functions to convert these key into the indexes.

        // add(), contains() are O(1) operation on average.
        // size(), isEmpty() are O(1) operation.

        HashSet<String> hashSet = new HashSet<>();
        System.out.println(hashSet.add("Vivek"));
        System.out.println(hashSet.add("Vivek one"));
        System.out.println(hashSet.add("Vivek"));
        hashSet.add("Vivek three");

        System.out.println("Size of the hash set is: " + hashSet.size());
        System.out.println(hashSet);
        System.out.println(hashSet.contains("Vivek"));
        System.out.println(hashSet.contains("ABC"));

        Iterator<String> it = hashSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println();
        System.out.println("Removed Vivek: ");
        hashSet.remove("Vivek");
        for(String s : hashSet){
            System.out.println(s);
        }
        System.out.println("If empty: " + hashSet.isEmpty());
        hashSet.clear();
        System.out.println("If empty after calling clear(): " + hashSet.isEmpty());
    }
}
