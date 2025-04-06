package com.Vivek.LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LargestDivisibleSubset_368 {
    private static void helper(int[] nums, int idx, List<Integer> result, List<Integer> temp, int prev) {
        if (idx >= nums.length) {
            if (temp.size() > result.size()) {
                result.clear();
                result.addAll(temp);
            }
            return;
        }

        if (prev == -1 || nums[idx] % prev == 0) {
            temp.add(nums[idx]);
            helper(nums, idx + 1, result, temp, nums[idx]);
            temp.remove(temp.size() - 1);
        }

        helper(nums, idx + 1, result, temp, prev);
    }

    private static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int prev = -1;
        helper(nums, 0, result, temp, prev);
        return result;
    }

    private static List<Integer> largestDivisibleSubset_(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int[] dp = new int[nums.length];
        int[] idxes = new int[nums.length];

        Arrays.fill(idxes, -1);
        Arrays.fill(dp, 1);

        int last_chosen_index = 0;
        int maxL = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        idxes[i] = j;
                    }

                    if (dp[i] > maxL) {
                        maxL = dp[i];
                        last_chosen_index = i;
                    }
                }
            }
        }

        while (last_chosen_index != -1) {
            result.add(nums[last_chosen_index]);
            last_chosen_index = idxes[last_chosen_index];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements in the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Length of the largest divisible subset: " + largestDivisibleSubset(nums));
        System.out.println("Length of the largest divisible subset: " + largestDivisibleSubset_(nums));
    }
}