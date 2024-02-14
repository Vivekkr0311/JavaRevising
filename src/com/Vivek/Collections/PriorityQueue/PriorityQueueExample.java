package com.Vivek.Collections.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueExample {

    // Priority Queue by default implements min heap data structure.
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Scanner input = new Scanner(System.in);

        System.out.println("How many element you wanna add ? ");
        int n = input.nextInt();
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            pq.add(input.nextInt());
        }

        System.out.println("Current top most element is: " + pq.peek());
        System.out.println("Removing top most element: " + pq.poll());
        System.out.println("Current top most element is: " + pq.peek());
    }
}
