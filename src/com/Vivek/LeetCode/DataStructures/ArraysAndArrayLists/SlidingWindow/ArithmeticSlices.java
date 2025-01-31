package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class ArithmeticSlices {
    private static int numberOfArithmeticSlicesDP(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                dp[i] = dp[i - 1] + 1;
                result += dp[i];
            }
        }
        return result;
    }

    private static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int dp = 0;
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                dp = dp + 1;
                result += dp;
            } else {
                dp = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Number of Arithmetic slices: " + numberOfArithmeticSlicesDP(nums));
        System.out.println("Number of Arithmetic slices: " + numberOfArithmeticSlices(nums));
    }
}
