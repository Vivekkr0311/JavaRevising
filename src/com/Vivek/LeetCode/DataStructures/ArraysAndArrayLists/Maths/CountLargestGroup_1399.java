package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Maths;

import java.util.*;

public class CountLargestGroup_1399 {
    private static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            n = n / 10;
        }
        return sum;
    }

    private static int countLargestGroup(int n) {
        int result = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            map.computeIfAbsent(sum, key -> new ArrayList<>()).add(i);
            maxLength = Math.max(maxLength, map.get(sum).size());
        }

        for (Map.Entry<Integer, List<Integer>> eachEntry : map.entrySet()) {
            if (eachEntry.getValue().size() == maxLength) {
                result++;
            }
        }

        return result;
    }

    private static int countLargestGroup_(int n) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            maxCount = Math.max(maxCount, map.get(sum));
        }

        for (Integer counts : map.values()) {
            if (counts == maxCount) {
                result++;
            }
        }

        return result;
    }

    private static int countLargestGroup__(int n) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (maxSize == map.get(sum)) {
                result++;
            } else if (maxSize < map.get(sum)) {
                maxSize = map.get(sum);
                result = 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println("Total group: " + countLargestGroup(n));
        System.out.println("Total group: " + countLargestGroup_(n));
        System.out.println("Total group: " + countLargestGroup__(n));
    }
}