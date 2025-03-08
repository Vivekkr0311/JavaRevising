package com.Vivek.LLD.StackUsingQueue;

public class RunnerClass {
    public static void main(String[] args) {
        MyStack2 stack = new MyStack2();
        stack.push(10);
        stack.display();
        stack.push(12);
        stack.display();
        stack.push(1);
        stack.display();
        stack.push(8);
        stack.display();
        System.out.println(stack.top());
        stack.pop();
        stack.display();
        stack.pop();
        stack.display();
        System.out.println(stack.empty());
        stack.pop();
        stack.display();
        System.out.println(stack.pop());
        stack.display();
        System.out.println(stack.empty());
    }
}