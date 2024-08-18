package com.Vivek.DataStructures.LinkedList.Questions;

public class LL {

    public class Node {
        public int data;
        public Node next;

        Node(){

        }

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public Node head;
    public Node tail;

    public void insertFirst(int val){
        if(head == null){
            head = new Node(val, null);
            tail = head;
            return;
        }

        head = new Node(val, head);
    }

    public void insertLast(int val){
        if(tail == null){
            head = new Node(val, null);
            tail = head;
            return;
        }

        tail.next = new Node(val, null);
        tail = tail.next;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public Node getHead(){
        return this.head;
    }

    public Node getTail(){
        return this.tail;
    }
}
