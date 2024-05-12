package com.Vivek.DataStructures.CircularLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(3);
        list.insert(6);
        list.insert(9);
        list.insert(36);
        list.insert(100);

        list.display();
        list.delete(3);
        list.display();
    }
}
