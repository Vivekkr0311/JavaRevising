package com.Vivek.DataStructures.Queue;

public class ArrayQ {

    private int[] queue;
    private int front = 0;
    private int back = 0;

    public ArrayQ(int size){
        queue = new int[size];
    }

    public void insert(int data){
        queue[back] = data;
        back++;
    }

    public void remove(){
        front++;
    }

    public void display(){
        for(int i = front; i < back; i++){
            System.out.print(queue[i] +  " -> ");
        }
        System.out.println(" END");
    }
}
