package com.Vivek.LeetCode.DataStructures.Stack.DesignAQueueUsingStack;

import java.util.Stack;

public class CustomQueue {
    private Stack<Integer> enqueStack = new Stack<>();
    private Stack<Integer> dequeStack = new Stack<>();

    public void display() {
        System.out.println("Queue: " + this.enqueStack);
    }

    public void enque(int data) {
        System.out.println(data + " is being enque in the queue");
        this.enqueStack.push(data);
    }

    public int deque() {
        if (this.enqueStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        for (int i = this.enqueStack.size() - 1; i >= 0; i--) {
            this.dequeStack.push(this.enqueStack.pop());
        }

        int ans = dequeStack.pop();
        System.out.println(ans + " is being deque from the queue");

        for (int i = this.dequeStack.size() - 1; i >= 0; i--) {
            this.enqueStack.push(this.dequeStack.pop());
        }
        return ans;
    }
}
