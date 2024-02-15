package com.Vivek.Collections.Map;

import java.util.*;

public class k_Most_Frequent_Elements {

    public static class MyCmp implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
            return -(m1.getValue() - m2.getValue());
        }
    }

    static void kMostFrequentElementTwo(Integer[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new MyCmp());

        for(int i = 0; i < k; i++){
            System.out.println(list.get(i) + " ");
        }
    }

    static void kMostFrequentElement(Integer[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry :: getValue));

        for(int i = list.size() - 1; i > 0 && k > 0; i--, k--){
            System.out.println(list.get(i) + " ");
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
        System.out.println();
        kMostFrequentElementTwo(arr, k);
    }
}
