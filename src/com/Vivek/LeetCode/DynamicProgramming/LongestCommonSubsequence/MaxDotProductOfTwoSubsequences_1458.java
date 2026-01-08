package com.Vivek.LeetCode.DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;
import java.util.Scanner;

// we this solution here, because it's similar to LCS problem.
public class MaxDotProductOfTwoSubsequences_1458 {
    private static int helper(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
       if (i == nums1.length || j == nums2.length) {
              return -100000000;
       }

       if (dp[i][j] != -100000000) {
           return dp[i][j];
       }

       int currentProduct = nums1[i] * nums2[j];
       int takeBoth = currentProduct + helper(nums1, nums2, i + 1, j + 1, dp);
       int takeI = helper(nums1, nums2, i, j + 1, dp);
       int takeJ = helper(nums1, nums2, i + 1, j, dp);

       dp[i][j] = Math.max(currentProduct, Math.max(takeBoth, Math.max(takeI, takeJ)));
       return dp[i][j];
    }

    private static int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[501][501];
        for (int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -100000000);
        }
        return helper(nums1, nums2, 0, 0, dp);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length of the firs array: ");
        int n = input.nextInt();

        int[] arr1 = new int[n];
        System.out.println("Enter elements of first array: ");
        for(int i = 0; i < n; i++){
            arr1[i] = input.nextInt();
        }

        System.out.println("Enter length of the second array: ");
        int m = input.nextInt();
        int[] arr2 = new int[m];

        System.out.println("Enter elements of second array: ");
        for(int i = 0; i < m; i++){
            arr2[i] = input.nextInt();
        }

        System.out.println("Maximum Dot Product of two subsequences is: " + maxDotProduct(arr1, arr2));
    }
}
