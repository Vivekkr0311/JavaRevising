package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.TwoPointer;

import java.util.*;

public class CountEqualAndDivisibleParisInAnArray_2176 {
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int countPairs_(int[] nums, int k) {
        int result = 0;
        int n = nums.length;

        Map<Integer, List<Integer>> indicesMap = new HashMap<>();
        // storing indices of each number
        for (int i = 0; i < n; i++) {
            indicesMap.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        Set<Integer> div = new HashSet<>();
        // computing all factors of k
        for (int f = 1; f * f <= k; f++) {
            if (k % f == 0) {
                div.add(f);
                div.add(k / f);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : indicesMap.entrySet()) {
            List<Integer> indices = entry.getValue();

            Map<Integer, Integer> factorsMap = new HashMap<>();

            for (int i : indices) {
                int gcd = gcd(i, k);
                int j = k / gcd;

                result += factorsMap.getOrDefault(j, 0);
                for (int f : div) {
                    if (i % f == 0) {
                        factorsMap.put(f, factorsMap.getOrDefault(f, 0) + 1);
                    }
                }
            }
        }
        return result;
    }

    private static int countPairs(int[] nums, int k) {
        int result = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the array:");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        System.out.println("Number of good pairs: " + countPairs(nums, k));
        System.out.println("Number of good pairs: " + countPairs_(nums, k));
    }
}