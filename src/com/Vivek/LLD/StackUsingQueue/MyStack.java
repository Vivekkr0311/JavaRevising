package com.Vivek.LLD.StackUsingQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    private ArrayDeque<Integer> queue;

    public MyStack() {
        this.queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int x = queue.removeLast();
        return x;
    }

    public int top() {
        int x = queue.peekLast();
        return x;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void display() {
        System.out.println(this.queue);
    }
}
