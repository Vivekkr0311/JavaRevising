package com.Vivek.DataStructures.Queue;

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

        ArrayQ queueTwo = new ArrayQ(5);
        queueTwo.insert(10);
        queueTwo.insert(12);
        queueTwo.insert(20);
        queueTwo.insert(40);

        queueTwo.display();
        queueTwo.remove();
        queueTwo.display();

        queueTwo.insert(1000);
        queueTwo.display();
        queueTwo.remove();
        queueTwo.display();


    }
}
