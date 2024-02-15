package com.Vivek.Collections.Map;

import java.util.*;

public class k_Most_Frequent_Elements {

    public static class MyCmp implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
            return -(m1.getValue() - m2.getValue());
        }
    }

    public static class MyCmpForOrder implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
            if(m1.getValue() == m2.getValue()){
                return m1.getKey() - m2.getKey();
            }else{
                return m2.getValue() - m1.getValue();
            }
        }
    }

    static void kMostFrequentElementThree(Integer[] arr, int k){
        // This solution will intact the order of the nubmers, becasue of using MyCmpOrder()
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 1) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new MyCmpForOrder());

        for(int i = 0; i < k; i++){
            System.out.println(list.get(i) + " ");
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
        kMostFrequentElementTwo(arr, k);
        System.out.println();
        kMostFrequentElementThree(arr, k);
    }
}
