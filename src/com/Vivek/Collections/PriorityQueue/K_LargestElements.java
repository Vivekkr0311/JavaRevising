package com.Vivek.Collections.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class K_LargestElements {

    static void kLargestElements(PriorityQueue<Integer> maxHeap, int k){
        if(maxHeap.isEmpty()){
            System.out.println("No elements");
            return;
        }

        while(!maxHeap.isEmpty() && k > 0){
            System.out.print(maxHeap.poll() + " ");
            k--;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many element you have: ");
        int n = input.nextInt();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            maxHeap.add(input.nextInt());
        }

        System.out.println("Enter how many largest element you want (k): ");
        int k = input.nextInt();
        System.out.print("K Largest element are: ");
        kLargestElements(maxHeap, k);
    }
}
