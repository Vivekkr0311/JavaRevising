package com.Vivek.LeetCode.DataStructures.Stack.DesignAQueueUsingStack;

import java.util.Stack;

public class RemoveOptimizedQueueUsingStacks {
    private Stack<Integer> enque;
    private Stack<Integer> deque;

    public RemoveOptimizedQueueUsingStacks() {
        this.enque = new Stack<>();
        this.deque = new Stack<>();
    }

    public void push(int x) {
        while (!enque.isEmpty()) {
            this.deque.push(this.enque.pop());
        }

        this.enque.push(x);

        while (!deque.isEmpty()) {
            this.enque.push(deque.pop());
        }
    }

    public int pop() {
        return this.enque.pop();
    }

    public int peek() {
        return this.enque.peek();
    }

    public boolean empty() {
        return enque.isEmpty();
    }

    public void display() {
        if (enque.isEmpty())
            System.out.println("[]");

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = enque.size() - 1; i >= 1; i--) {
            sb.append(enque.get(i) + ", ");
        }

        sb.append(enque.get(0) + "]");
        System.out.println(sb);
    }
}
