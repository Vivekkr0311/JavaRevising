package com.Vivek.LeetCode.Collections.PriorityQueue;

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

    static void kLargestElementsEfficient(Integer[] arr, int k){
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            minHeap.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            if(minHeap.peek() < arr[i]){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        while(!minHeap.isEmpty()){
            System.out.print(minHeap.poll() + " ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many element you have: ");
        int n = input.nextInt();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Integer[] arr = new Integer[n]; // For only efficient solution.
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            int temp = input.nextInt();
            maxHeap.add(temp);
            arr[i] = temp;
        }

        System.out.println("Enter how many largest element you want (k): ");
        int k = input.nextInt();
        System.out.print("K Largest element are: ");
        kLargestElements(maxHeap, k);
        System.out.println();
        System.out.print("K Largest element are: ");
        kLargestElementsEfficient(arr, k);
    }
}
