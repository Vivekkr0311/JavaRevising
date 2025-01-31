package com.Vivek.LeetCode.Collections.ListInterface;

import java.util.*;

public class ListInterfaceExample {
    // List interface is implemented by ArrayList, LinkedList and Stack.
    public static void main(String[] args) {
        // You cannot define like this, because List is an interface,
        // in order to make its object you will have to override abstract methods which are
        // present in the List interface. But we already have those methods overridden in some class
        // like ArrayList, Stack, LinkedList, and Vector. So we don't need to do this extra efforts
        // to override methods of List interface
//        List<Integer> list = new List<Integer>();

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        ListIterator<Integer> it = list.listIterator();
        // Forward traversing
        while(it.hasNext()){
            System.out.print(it.next()+ " ");
        }

        System.out.println();

        it = list.listIterator(list.size());
        // Backward traversing
        while(it.hasPrevious()){
            System.out.print(it.previous() + " ");
        }
    }
}
