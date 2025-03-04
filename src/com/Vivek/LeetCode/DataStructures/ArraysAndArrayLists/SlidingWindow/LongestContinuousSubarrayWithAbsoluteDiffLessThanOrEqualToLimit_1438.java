package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_1438 {
    private static boolean checkDiff(int[] nums, int start, int end, int limit) {
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (Math.abs(nums[i] - nums[j]) > limit) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int longestSubarrayBruteForce(int[] nums, int limit) {
        int ansLength = 0;

        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                if (checkDiff(nums, left, right, limit)) {
                    ansLength = Math.max(ansLength, right - left + 1);
                }
            }
        }
        return ansLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the limit: ");
        int limit = scanner.nextInt();

        System.out.println("Longest subarray length with absolute diff " + limit + " is " + longestSubarrayBruteForce(nums, limit));
    }
}
