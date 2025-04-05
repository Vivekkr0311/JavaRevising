package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class SumOfAllSubsetXORTotals_1863 {
    private static int sum = 0;

    private static void helper(int[] nums, int idx, int xor) {
        if (idx == nums.length) {
            sum = sum + xor;
            return;
        }

        helper(nums, idx + 1, xor ^ nums[idx]);
        helper(nums, idx + 1, xor);
    }

    private static int subsetXORSum(int[] nums) {
        helper(nums, 0, 0);
        return sum;
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

        System.out.println("Sum of all subset XOR totals: " + subsetXORSum(nums));
    }
}