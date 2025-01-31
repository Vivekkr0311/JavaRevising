package com.Vivek.LeetCode.DynamicProgramming;

import java.util.Scanner;

public class MaximumLengthOfRepeatedSubArray {
    private static int helper(int[] nums1, int[] nums2, int pNum1, int pNum2, int count) {
        if (pNum1 >= nums1.length || pNum2 >= nums2.length) {
            return count;
        }

        if (nums1[pNum1] == nums2[pNum2]) {
            count = helper(nums1, nums2, pNum1 + 1, pNum2 + 1, count + 1);
        }
        return Math.max(
                count,
                Math.max(
                        helper(nums1, nums2, pNum1 + 1, pNum2, 0),
                        helper(nums1, nums2, pNum1, pNum2 + 1, 0)
                )
        );
    }

    private static int findLengthRecursion(int[] nums1, int[] nums2) {
        return helper(nums1, nums2, 0, 0, 0);
    }

    public static int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of nums1: ");
        int n1 = scanner.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter each element of nums1: ");
        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.println("Enter length of nums2: ");
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter each element of nums2: ");
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }

        System.out.println("Maximum length of common subarray is: " + findLengthRecursion(nums1, nums2));
        System.out.println("Maximum length of common subarray is: " + findLength(nums1, nums2));
    }
}
