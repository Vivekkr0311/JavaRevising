package com.Vivek.Collections.PriorityQueue;

import java.util.*;

public class k_Most_Frequent_Elements {

    static void kMostFrequentElement(Integer[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                Comparator.comparing(Map.Entry :: getValue, Collections.reverseOrder())
        );
        for(Map.Entry<Integer, Integer> item : map.entrySet()){
            maxHeap.add(item);
        }

        while(!maxHeap.isEmpty() && k > 0) {
            System.out.println(maxHeap.peek().getKey() + " " + maxHeap.peek().getValue());
            maxHeap.poll();
            k--;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many element do you have? ");
        int n = input.nextInt();
        System.out.println("Enter each elements: ");
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Enter value of 'k', to take k most frequent elements: ");
        int k = input.nextInt();
        kMostFrequentElement(arr, k);
    }
}
