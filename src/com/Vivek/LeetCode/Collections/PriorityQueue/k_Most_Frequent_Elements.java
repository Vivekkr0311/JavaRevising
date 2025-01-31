package com.Vivek.LeetCode.Collections.PriorityQueue;

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

    public static class MyCmp implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
            if(m1.getValue() ==  m2.getValue()){
                return m1.getKey() - m2.getKey();
            }else{
                return -(m1.getValue() - m2.getValue());
            }
        }
    }

    static void kMostFrequenctEfficient(Integer[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new MyCmp());
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            maxHeap.add(m);
        }

        for(int i = 0; i < k; i++){
            System.out.println(maxHeap.poll());
        }
    }

    static void kMostFrequenctEfficientLinearTime(Integer[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }

        List<List<Integer>> freq = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            freq.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            freq.get(m.getValue()).add(m.getKey());
        }

        int count = 0;
        for(int i = arr.length - 1; i > 0; i--){
            for(int x : freq.get(i)){
                System.out.print(x + " ");
                count++;
                if(count == k){
                    return;
                }
            }
        }
    }

    static void kMostFrequenctEfficientLinearTimeTwo(Integer[] arr, int k){
        // First occurrence printed first.
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }

        List<List<Integer>> freq = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            freq.add(new ArrayList<>());
        }

        for(int i = 0; i < arr.length; i++){
            int f = map.get(arr[i]);

            if(f != -1){
                freq.get(f).add(arr[i]);
                map.put(arr[i], -1);
            }
        }

        int count = 0;
        for(int i = arr.length - 1; i > 0; i--){
            for(int x : freq.get(i)){
                System.out.print(x + " ");
                count++;
                if(count == k){
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        // input: 10 5 20 5 10 10 30, n = 7, k=2
        // output: 10=4, 5=3
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
        System.out.println();
        kMostFrequenctEfficient(arr, k);
        System.out.println();
        kMostFrequenctEfficientLinearTime(arr, k);
        System.out.println();
        kMostFrequenctEfficientLinearTimeTwo(arr, k);
    }
}
