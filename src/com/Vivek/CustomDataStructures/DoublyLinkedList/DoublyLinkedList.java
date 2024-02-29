package com.Vivek.CustomDataStructures.DoublyLinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node prev, Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public void insertFirst(int data){
        if(head == null){
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
            return;
        }
        Node newNode =  new Node(data);
        newNode.next = head;
        newNode.prev = null;

        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
    }

    public void insertLast(int data){
        if (head == null) {
            insertFirst(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void insertAt(int data, int idx){
        if(idx == 0){
            insertFirst(data);
            return;
        }
        if(idx == size){
            insertLast(data);
            return;
        }

        Node temp = head;
        for(int i = 0; i < idx; i++){
            temp = temp.next;
        }

        Node newNode = new Node(data, temp, temp.next.next);
        temp.next = newNode;
    }

    public void displayForward(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println(" END");
    }

    public void displayBackward(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data +  " <-> ");
            temp = temp.prev;
        }
        System.out.println(" START");
    }
}
