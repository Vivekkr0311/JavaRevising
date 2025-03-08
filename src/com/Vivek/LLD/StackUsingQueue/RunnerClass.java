package com.Vivek.LLD.StackUsingQueue;

public class RunnerClass {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.display();
        System.out.println(stack.pop());
        stack.display();
        System.out.println(stack.empty());
    }
}