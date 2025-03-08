package com.Vivek.LLD.StackUsingQueue;

public class MyStack2 {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    private Integer[] queue;
    private Integer top;

    public MyStack2() {
        this.queue = new Integer[10];
        this.top = -1;
    }

    public void push(int x) {
        if (queue.length == top) {
            Integer[] temp = new Integer[queue.length * 2];
            for (int i = 0; i < queue.length; i++) {
                temp[i] = queue[i];
            }

            queue = temp;
        }
        this.top += 1;
        queue[top] = x;
    }

    public int pop() {
        int x;
        if (top != -1) {
            x = queue[top];
            queue[top] = null;
            top -= 1;
        } else {
            x = -1;
        }
        return x;
    }

    public int top() {
        int x;
        if (top != -1) {
            x = queue[top];
        } else {
            x = -1;
        }
        return x;
    }

    public boolean empty() {
        return top == -1;
    }

    public void display() {
        if (top != -1) {
            System.out.print("[");
            for (int i = 0; i < queue.length; i++) {
                Integer item = queue[i];
                if (item != null) {
                    System.out.print(queue[i] + " ");
                }
            }
            System.out.println("]");
        } else {
            System.out.println("[]");
        }
    }
}