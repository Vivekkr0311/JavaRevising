package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;
// https://leetcode.com/problems/binary-subarrays-with-sum/description/?envType=problem-list-v2&envId=sliding-window??

import java.util.Arrays;
import java.util.Scanner;

public class BinarySubarraysWithSum_930 {
    private static int numSubaraysWithSum(int[] nums, int goal) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int sum = 0;
        int res = 0;

        while (j < n) {
            sum += nums[j];

            while (sum > goal) {
                sum -= nums[i];
                i++;
            }

            if (sum == goal) {
                res = res + j - i + 1;
                j++;
            }
        }

        return res;
    }

    private static int numSubaraysWithSumBruteForce(int[] nums, int goal) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == goal) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the goal: ");
        int goal = scanner.nextInt();

        System.out.println("Number of subarrays with sum " + goal + " is " + numSubaraysWithSum(nums, goal));
        System.out.println("Number of subarrays with sum " + goal + " is " + numSubaraysWithSumBruteForce(nums, goal));
    }
}
