package com.Vivek.Collections.PriorityQueue;

import java.util.*;

public class ConvertingAnArrayToPriorityQueue {

    static PriorityQueue<Integer> getPriorityQueue(Integer[] arr){
        return new PriorityQueue<>(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many elements? ");
        int n = input.nextInt();
        Integer[] arr = new Integer[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        PriorityQueue<Integer> priorityQueue = getPriorityQueue(arr);
        System.out.println("After conversion we get: " + priorityQueue);
    }
}
