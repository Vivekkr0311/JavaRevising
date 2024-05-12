package com.Vivek.DataStructures.CircularLinkedList;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    private class Node{
        private int data;
        private Node next;

        private Node(int data){
            this.data = data;
        }
    }

    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head =  newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public void display(){
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while(temp != head);
        System.out.println(temp.data);
    }

    public void delete(int val){
        Node node = head;
        if(node == null){
            return;
        }
        if(node.data == val){
            head = head.next;
            tail.next = head;
            return;
        }
        do{
            Node n = node.next;
            if(n.data == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while(node != head);
    }
}
