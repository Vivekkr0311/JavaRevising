package com.Vivek.CustomDataStructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertEnd(1);
        list.insertFirst(6);
        list.insertFirst(7);
        list.insertEnd(8);
        list.display();
        list.insertAt(100, 3);
        list.display();
        list.insertAt(200, 1);
        list.display();
        list.insertAt(4, 464);
        System.out.println(list.getSize());
    }
}
