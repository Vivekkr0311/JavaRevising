package com.Vivek.Collections.ListInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTraversal {
    static void traversingOne(ArrayList<String> list){
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static void traversingTwo(ArrayList<String> list){
        for(String item : list){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    static void traversingThird(ArrayList<String> list){
        // This syntax is universal, you can this syntax for every collections.
        // These collections must have implemented Iterator as root interface.
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    static void traversingFour(ArrayList<String> list){
        list.forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    static void removingItemWhileTraversing(ArrayList<Integer> list){
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            // Make sure, it.next() is called one time inside your loop.
            int item = (Integer) it.next();

            if(item < 10){
                it.remove();
            }else{
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }

    static void modifyingWhileTraversing(ArrayList<Integer> list){
        // Remember modification on ArrayList is different from the modification on the individual items
        // of the ArrayList.

        // Each item of the ArrayList is a reference to the objects. These references are stored in contiguous memory,
        // while actual object might be stored in different locations.
        // This is why, we can modify the actual item (objects) using these references.
        // This is why, to remove an item we have to use iterator based method to traverse the ArrayList.
        for(int i = 0; i < list.size(); i++){
            int x =  list.get(i);
            list.set(i, x * 2);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        ArrayList<String> listOne = new ArrayList<>();
        listOne.add("abc");
        listOne.add("def");
        listOne.add("ghi");
        listOne.add("jkl");
        listOne.add("mno");
        listOne.add("pqr");

        traversingOne(listOne);
        traversingTwo(listOne);
        traversingThird(listOne);
        traversingFour(listOne);

        ArrayList<Integer> listTwo = new ArrayList<>();
        listTwo.add(10);
        listTwo.add(20);
        listTwo.add(5);
        listTwo.add(0);
        listTwo.add(2);
        listTwo.add(40);
        listTwo.add(60);
        listTwo.add(80);
        listTwo.add(100);

        removingItemWhileTraversing(listTwo);
        modifyingWhileTraversing(listTwo);
    }
}
