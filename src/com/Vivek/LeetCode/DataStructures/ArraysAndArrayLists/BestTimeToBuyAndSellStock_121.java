package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock_121 {
    private static int maxProfit(int[] nums) {
        int n = nums.length;
        int[] maxFromRight = new int[n];

        maxFromRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(nums[i], maxFromRight[i + 1]);
        }

        int diff = 0;
        for (int i = 0; i < n; i++) {
            diff = Math.max(diff, maxFromRight[i] - nums[i]);
        }
        return diff;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of prices:");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter the prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.println("Maximum profit: " + maxProfit(prices));
    }
}
