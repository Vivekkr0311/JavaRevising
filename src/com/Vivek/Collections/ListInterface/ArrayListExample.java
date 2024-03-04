package com.Vivek.Collections.ListInterface;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Advantage overs normal arrays are:
        //              1. ArrayList are dynamic sized arrays
        //              2. ArrayList has rich library methods

        // ArrayList are created of non-primitive data types like Integer, String, Boolean etc.
        // As arraylist is a collection.
        ArrayList<Integer> list = new ArrayList<>();

        // .add() adds element at the end of the list.
        list.add(10);
        list.add(20);
        list.add(40);
        list.add(60);

        System.out.println(list);
    }
}
