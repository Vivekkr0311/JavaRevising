package com.Vivek.Collections.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueImplementingMaxHeap {

    // Priority Queue by default implements min heap data structure.
    // But here we will use "Collections.reverseOrder()" to make this max heap.
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many elements you wanna add ? ");
        int n = input.nextInt();

        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            maxHeap.add(input.nextInt());
        }

        System.out.println("Current root element is: " + maxHeap.peek());
        System.out.println("Removing current root element: " + maxHeap.poll());
        System.out.println("Current root element is: " + maxHeap.peek());
    }
}
