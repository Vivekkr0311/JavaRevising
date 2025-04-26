package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.*;

public class SubarraySumsDivisibleByK_974 {
    private static long subarraysDivByK(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        Map<Integer, Long> mp = new HashMap<>(); // remainder -> count
        long sum = 0;
        long result = 0;

        mp.put(0, 1L);

        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulo == k) {
                sum += 1;
            }

            int r1 = (int)(sum % modulo);
            int r2 = (r1 - k + modulo) % modulo;

            result += mp.getOrDefault(r2, 0L);
            mp.put(r1, mp.getOrDefault(r1, 0L) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }

        System.out.println("Enter modulo: ");
        int modulo = scanner.nextInt();

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Total number of subarrays with sum divisible by " + k + " is " + subarraysDivByK(nums, modulo, k));
    }
}
