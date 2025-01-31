package com.Vivek.LeetCode.DataStructures.LinkedList;

public class Node {
    public int data;
    public Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node node){
        this.data = data;
        this.next = node;
    }

    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(" END");
    }
}
