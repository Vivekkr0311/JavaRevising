package com.Vivek.LeetCode.DataStructures.Stack.DesignAQueueUsingStack;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> enque;
    private Stack<Integer> deque;

    public MyQueue() {
        this.enque = new Stack<>();
        this.deque = new Stack<>();
    }

    public void push(int x) {
        this.enque.push(x);
    }

    public int pop() {
        for (int i = enque.size() - 1; i >= 0; i--) {
            this.deque.push(this.enque.pop());
        }

        int res = deque.pop();

        for (int i = deque.size() - 1; i >= 0; i--) {
            this.enque.push(this.deque.pop());
        }
        return res;
    }

    public int peek() {
        for (int i = enque.size() - 1; i >= 0; i--) {
            this.deque.push(this.enque.pop());
        }

        int res = deque.peek();

        for (int i = deque.size() - 1; i >= 0; i--) {
            this.enque.push(this.deque.pop());
        }
        return res;
    }

    public boolean empty() {
        return enque.isEmpty();
    }

    public void display(){
        System.out.println(this.enque);
    }
}