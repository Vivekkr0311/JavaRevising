package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

// https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=problem-list-v2&envId=sliding-window
public class MaxConsecutiveOnesIII_1004 {
    private static int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        int n = nums.length;
        int maxLength = 0;

        while (j < n) {
            if (nums[j] == 0) {
                zeroCount++;
            }

            while (i <= j && zeroCount > k) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
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

        System.out.println("Maximum consecutive ones subarray if " + k + " elements are flipped " + longestOnes(nums, k));
    }
}