package com.Vivek.CustomDataStructures.Queue;

public class Queue {

    private Node front;
    private Node back;

    private class Node {
        private int data;
        private Node before;

        private Node(int data){
            this.data = data;
        }
    }

    public void insert(int data){
        if(front == null){
            Node newNode = new Node(data);
            front = newNode;
            back = newNode;
            return;
        }

        Node newNode = new Node(data);
        newNode.before = back;
        back = newNode;
    }

    public void remove(){
        if(front == null){
            System.out.println("Nothing is there to remove");
            return;
        }

        Node temp = back;
        while(temp.before != front){
            temp = temp.before;
        }
        front = temp;
    }

    public void display(){
        Node temp = back;
        System.out.println("Queue is shown in reverse order: ");
        while(temp != front) {
            System.out.print(temp.data + " -> ");
            temp = temp.before;
        }
        System.out.print(temp.data + " -> ");
        System.out.println(" FRONT");
    }
}
