package com.Vivek.DataStructures.LinkedList;

import java.util.Objects;

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

    private Node insertRecursion(Node node, int data, int idx){
        if(idx == 0) {
            Node temp = new Node(data, node);
            size++;
            return temp;
        }
        node.next = insertRecursion(node.next, data, idx - 1);
        return node;
    }

    public void insertAtRecursion(int data, int idx){
        head = insertRecursion(head, data, idx);
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(" END");
    }

    public void deleteFirst(){
        head = head.next;
        size--;
    }

    public void deleteEnd(){
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public void deleteFrom(int idx){
        if(idx < 0){
            System.out.println("Invalid idx");
            return;
        }
        if(idx > size){
            System.out.println("Size is " + getSize());
            System.out.println("Cannot delete from " + idx);
            return;
        }
        if(idx == 0){
            deleteFirst();
            return;
        }
        if(idx == size){
            deleteEnd();
            return;
        }
        Node temp = head;
        for(int i = 1; i < idx; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public int getSize(){
        return this.size;
    }

    // Questions
    // Remove duplicate nodes
    public void removeDuplicate(){
        Node curr = head;

        while(curr.next != null) {
            if(curr.data ==  curr.next.data){
                curr.next = curr.next.next;
                size--;
            }else{
                curr = curr.next;
            }
        }
        tail = curr;
        tail.next = null;
    }

    // Merge two sorted list
    public Node merge(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        LinkedList newList = new LinkedList();

        while(temp1 != null || temp2 != null){
            if(temp1.data == temp2.data){
                newList.insertEnd(temp1.data);
                newList.insertEnd(temp2.data);
                temp1 = temp1.next;
                temp2 = temp2.next;
            }else if(temp1.data < temp2.data){
                newList.insertEnd(temp1.data);
                temp1 = temp1.next;
            }else{
                newList.insertEnd(temp2.data);
                temp2 = temp2.next;
            }
        }

        if(temp1 == null && temp2 != null){
            while(temp2 != null){
                newList.insertEnd(temp2.data);
                temp2 = temp2.next;
            }
        }

        if(temp1 != null && temp2 == null){
            while(temp1 != null){
                newList.insertEnd(temp1.data);
                temp1 = temp1.next;
            }
        }
        return newList.head;
    }
}
