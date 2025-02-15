package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

// https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=problem-list-v2&envId=sliding-window
public class MaxConsecutiveOnesIII_1004 {
    private static int helperCountOnesAndZeros(int[] nums, int i, int j) {
        int ans = 0;

        for (int k = i; k <= j; k++) {
            if (nums[k] == 0) {
                ans += 1;
            }
        }
        return ans;
    }

    private static int longestOnesBruteForce(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int count_zeros = helperCountOnesAndZeros(nums, i, j);

                if (count_zeros <= k) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    private static int longestOnesBruteForce2(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int count_zeros = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    count_zeros++;
                }

                if (count_zeros <= k) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    private static int longestOnesSlidingWindow(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int n = nums.length;

        int count_zeros = 0;
        while (j < n) {
            if (nums[j] == 0) {
                count_zeros++;
            }

            while (i <= j && count_zeros > k) {
                if (nums[i] == 0) {
                    count_zeros--;
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
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

        System.out.println("Enter the k: ");
        int k = scanner.nextInt();

        System.out.println("Maximum consecutive ones subarray if " + k + " elements are flipped " + longestOnesBruteForce(nums, k));
        System.out.println("Maximum consecutive ones subarray if " + k + " elements are flipped " + longestOnesSlidingWindow(nums, k));
    }
}