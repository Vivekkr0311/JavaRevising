package com.Vivek.CustomDataStructures.LinkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.size = 0;
    }

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        this.size++;

        if(tail == null){
            tail = head;
        }
    }

    public void insertEnd(int data){
        Node newNode = new Node(data);
        if(tail == null){
            insertFirst(data);
            return;
        }
        tail.next = newNode;
        tail = newNode;
        this.size++;
    }

    public void insertAt(int data, int idx){
        if(idx > size){
            System.out.println("cannot insert at " + idx);
            System.out.println("List size is " + getSize());
            return;
        }
        if(idx == 0){
            insertFirst(data);
            return;
        }
        if(idx == size){
            insertEnd(data);
            return;
        }
        Node temp = head;
        for(int i = 1; i < idx; i++){
            temp = temp.next;
        }
        Node newNode = new Node(data, temp.next);
        temp.next = newNode;
        size++;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(" END");
    }

    public int getSize(){
        return this.size;
    }
}
