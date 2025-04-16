package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class CountTheNumberOfGoodSubarrays_2537 {
    private static long countGood(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        int windowPairCount = 0;

        while (right < n) {
            windowPairCount += map.getOrDefault(nums[right], 0);
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (windowPairCount >= k) {
                count += (n - right);
                map.put(nums[left], map.get(nums[left]) - 1);
                windowPairCount -= map.get(nums[left]);
                left++;
            }
            right++;
        }

        return count;
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

        System.out.println("Number of good subarrays: " + countGood(nums, k));
    }
}