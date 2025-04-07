package com.Vivek.LeetCode.DynamicProgramming;

import java.util.Scanner;

public class PartitionEqualSubsetSum_416 {
    private static boolean helper(int[] nums, int idx, int target) {
        if (target == 0) {
            return true;
        }

        if (idx >= nums.length || target < 0) {
            return false;
        }

        boolean take = helper(nums, idx + 1, target - nums[idx]);
        boolean dontTake = helper(nums, idx + 1, target);

        return take || dontTake;
    }

    private static int sumOfArray(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        return total;
    }

    private static boolean canPartition(int[] nums) {
        int target = sumOfArray(nums);
        if ((target & 1) == 1) {
            return false;
        }
        return helper(nums, 0, target / 2);
    }

    private static boolean canPartition_(int[] nums) {
        int total = sumOfArray(nums);
        if ((total & 1) == 1) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Sum 0 is always possible

        for (int num : nums) {
            // Traverse backward to prevent overwriting dp[j - num] in same iteration
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Can the array be partitioned into two subsets with equal sum? " + canPartition(nums));
        System.out.println("Can the array be partitioned into two subsets with equal sum? " + canPartition_(nums));
    }
}