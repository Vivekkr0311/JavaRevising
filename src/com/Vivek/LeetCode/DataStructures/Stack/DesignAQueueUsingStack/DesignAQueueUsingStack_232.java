package com.Vivek.LeetCode.DataStructures.Stack.DesignAQueueUsingStack;
//https://leetcode.com/problems/implement-queue-using-stacks/description/
import java.util.Scanner;

public class DesignAQueueUsingStack_232 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many element do you want to insert in the queue? ");
        int n = scanner.nextInt();
        MyQueue queue = new MyQueue();

        System.out.println("push the elements: ");
        for (int i = 0; i < n; i++) {
            queue.push(scanner.nextInt());
        }

        queue.display();

        int firstpop = queue.pop();
        System.out.println("first deque/ pop data: " + firstpop);
        queue.display();

        int secondpop = queue.pop();
        System.out.println("second deque/ pop data: " + secondpop);
        queue.display();

        System.out.println("Insert something to check push: ");
        int firstpush = scanner.nextInt();
        queue.push(firstpush);
        queue.display();

        System.out.println("Insert something to check push: ");
        int secondpush = scanner.nextInt();
        queue.push(secondpush);
        queue.display();
    }
}
