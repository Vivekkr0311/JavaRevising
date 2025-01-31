package com.Vivek.LeetCode.DataStructures.Stack;

public class Stack {

    // Linked list implementation of Stack
    private int size = -1;
    private Node top;

    private class Node {

        private int data;
        private Node below;

        private Node(int data){
            this.data = data;
        }
    }

    public void push(int data){
        if(size == 0){
            Node newNode = new Node(data);
            top = newNode;
            size++;
        }
        Node newNode = new Node(data);
        newNode.below = top;
        top = newNode;
        size++;
    }

    public void pop(){
        if(size <= 0){
            System.out.println("Underflow");
            return;
        }
        top = top.below;
        size--;
    }

    public void display(){
        Node temp = top;
        while(temp.below != null){
            System.out.print(temp.data + " -> ");
            temp = temp.below;
        }
        System.out.println(" BOTTOM");
    }
}
