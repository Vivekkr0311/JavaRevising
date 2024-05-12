package com.Vivek.DataStructures.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(5);
        list.insertFirst(3);
        list.insertFirst(6);
        list.insertFirst(7);

        list.insertLast(10);

        list.insertAt(100, 2);
        list.displayBackward();
        list.displayForward();
        System.out.println("Delete first");
        list.deleteFirst();
        list.displayForward();
        System.out.println("Delete last");
        list.deleteLast();
        list.displayForward();
        System.out.println("Delete from a idx");
        list.deleteFrom(2);
        list.displayForward();
    }
}
