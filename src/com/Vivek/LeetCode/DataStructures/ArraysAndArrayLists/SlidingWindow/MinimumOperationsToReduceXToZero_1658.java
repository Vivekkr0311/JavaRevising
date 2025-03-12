package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MinimumOperationsToReduceXToZero_1658 {
    private static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }

        int requiredSum = totalSum - x;
        int sum = 0;
        int right = 0;
        int left = 0;
        int length = 0;

        if (requiredSum == 0) {
            return n;
        }

        if (requiredSum > 0) {
            while (right < n) {
                sum += nums[right];

                while (sum > requiredSum) {
                    sum -= nums[left];
                    left++;
                }

                if (sum == requiredSum) {
                    length = Math.max(length, right - left + 1);
                }
                right++;
            }
        }

        return length == 0 ? -1 : n - length;
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

        System.out.println("Enter x: ");
        int x = scanner.nextInt();

        System.out.println("Minimum operation required: " + minOperations(nums, x));
    }
}