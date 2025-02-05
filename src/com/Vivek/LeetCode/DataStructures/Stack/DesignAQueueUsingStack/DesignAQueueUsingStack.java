package com.Vivek.LeetCode.DataStructures.Stack.DesignAQueueUsingStack;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class DesignAQueueUsingStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many element do you want to insert in the queue? ");
        int n = scanner.nextInt();
        CustomQueue queue = new CustomQueue();

        System.out.println("Enque the elements: ");
        for (int i = 0; i < n; i++) {
            queue.enque(scanner.nextInt());
        }

        queue.display();

        int firstDeque = queue.deque();
        System.out.println("first dequeue data: " + firstDeque);
        queue.display();

        int secondDeque = queue.deque();
        System.out.println("second dequeue data: " + secondDeque);
        queue.display();

        System.out.println("Insert something to check enque: ");
        int firstEnque = scanner.nextInt();
        queue.enque(firstEnque);
        queue.display();

        System.out.println("Insert something to check enque: ");
        int secondEnque = scanner.nextInt();
        queue.enque(secondEnque);
        queue.display();
    }
}
