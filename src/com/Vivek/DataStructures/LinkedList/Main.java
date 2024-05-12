package com.Vivek.DataStructures.LinkedList;

import org.w3c.dom.Node;

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
        System.out.println("<--- Deleting --->");
        list.display();
        list.deleteFirst();
        list.display();
        list.deleteEnd();
        list.display();
        list.deleteFrom(2);
        list.display();

    }
}
