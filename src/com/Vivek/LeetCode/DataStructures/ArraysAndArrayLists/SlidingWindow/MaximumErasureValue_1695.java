package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaximumErasureValue_1695 {
    // This question is similar to "Longest Substring without repeating characters"
    private static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int windowSum = 0;
        Set<Integer> set = new HashSet<>();

        while (right < n) {
            if (set.contains(nums[right])) {
                windowSum -= nums[left];
                set.remove(nums[left]);
                left++;
            } else {
                windowSum += nums[right];
                set.add(nums[right]);
                right++;
                sum = Math.max(sum, windowSum);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Maximum sum of a subarray which can be erased: " + maximumUniqueSubarray(nums));
    }
}