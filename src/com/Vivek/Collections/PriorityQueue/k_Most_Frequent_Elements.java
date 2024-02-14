package com.Vivek.Collections.PriorityQueue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class k_Most_Frequent_Elements {

    static void kMostFrequentElement(Integer[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }

        for(Map.Entry<Integer, Integer> item: map.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) -> m1.getValue() - m2.getValue();
        );
        for(Map.Entry<Integer, Integer> item : map.entrySet()){
            maxHeap.add(item);
        }

        while(!maxHeap.isEmpty()) {
            System.out.println(maxHeap.peek().getKey() + " " + maxHeap.peek().getValue());
            maxHeap.poll();
        }
    }
    public static void main(String[] args) {
        Integer[] arr = { 10, 5, 20, 5, 10, 10, 30};
        int k = 2;
        kMostFrequentElement(arr, k);
    }
}
