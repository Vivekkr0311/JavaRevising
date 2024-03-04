package com.Vivek.Collections.ListInterface;

import java.util.ArrayList;

// Time complexities:
// 1. add() takes amortized O(1)
// 2. size() takes O(1)
// 3. isEmpty() takes O(1)
// 4. get() takes O(1)
// 5. set() takes O(1)

// Following takes O(n)
// 1. contains()
// 2. indexOf()
// 3. lastIndexOf()
// 4. remove() both version index one and also object one
// 5. add(idx, obj)

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

        list.add(4, 100);

        // Below will add at 0, NOTE!! it will not replace.
        list.add(0, 4);
        System.out.println(list);

        boolean isPrsent = list.contains(40);
        System.out.println(isPrsent);

        list.remove(3);
        isPrsent = list.contains(40);
        System.out.println(isPrsent);

        // Method overloading is implemented for remove() method, mean you can different parameter as well.
        // This different parameter is an object.
        // Example:
        System.out.println(list);
        Integer a = 100;
        boolean result  = list.remove(a);
        System.out.println(list + " " + result);
        result = list.remove(a);
        System.out.println(list + " " + result);

        //get(i)
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //set()
        for(int i = 0; i < list.size(); i++){
            list.set(i, list.get(i) + 2);
        }
        System.out.println(list);

        //indexOf()
        Integer obj = 62;
        int idx = list.indexOf(obj);
        System.out.println("idx of " + obj + " is " + idx);

        //lastIndexOf()
        list.add(12);
        idx = list.lastIndexOf(12);
        System.out.println(list);
        System.out.println("last idx of 12 is " + idx);

        idx = list.lastIndexOf(1000);
        System.out.println("idx of 1000 " + idx);

        idx = list.indexOf(2000);
        System.out.println("idx of 2000 " + idx);

        //isEmpty()
        System.out.println(list);
        System.out.println("list is empty ? " + list.isEmpty());

        //clear()
        list.clear();
        System.out.println(list);
        System.out.println("list is empty ? " + list.isEmpty());
    }
}
