package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.TwoPointer;

import java.util.Scanner;

public class MaximumValueOfAnOrderedTripletI_2874 {
    private static long maximumValue_(int[] nums) {
        long maxValue = 0;
        int n = nums.length;

        long maxDiff = 0;
        long maxI = 0;

        for (int k = 0; k < n; k++) {
            maxValue = Math.max(
                    maxValue,
                    maxDiff * nums[k]
            );

            maxDiff = Math.max(maxDiff, maxI - nums[k]);
            maxI = Math.max(maxI, nums[k]);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Maximum value of an ordered triplet: " + maximumValue_(nums));
    }
}