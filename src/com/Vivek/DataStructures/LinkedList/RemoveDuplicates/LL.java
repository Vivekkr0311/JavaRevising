package com.Vivek.DataStructures.LinkedList.RemoveDuplicates;


public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL(){
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

    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(4);
        list.insertFirst(4);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertFirst(1);
        list.display();
        list.removeDuplicate();
        list.display();
    }
}

