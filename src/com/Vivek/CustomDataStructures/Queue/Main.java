package com.Vivek.CustomDataStructures.Queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.insert(6);
        queue.insert(8);
        queue.insert(2);
        queue.insert(10);

        queue.display();

        queue.remove();
        queue.display();
    }
}
