package com.Vivek.DataStructures.Stack;

public class ArrStack {

    private int[] stack;
    private int top = -1;

    public ArrStack(int size){
        stack = new int[size];
    }

    public void push(int data){
        top++;
        stack[top] = data;
    }

    public void pop(){
        if(top < 0){
            System.out.println("Underflow");
            return;
        }
        top--;
    }

    public void display(){
        for(int i = stack.length - 1; i >= 0; i--){
            System.out.print(stack[i] + " -> ");
        }
        System.out.println("BOTTOM");
    }
}
