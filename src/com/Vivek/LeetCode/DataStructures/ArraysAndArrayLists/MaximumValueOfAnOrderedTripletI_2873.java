package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class MaximumValueOfAnOrderedTripletI_2873 {
    private static long maximumValue_(int[] nums) {
        long maxValue = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long currDiff = nums[i] - nums[j];

                if (currDiff >= 0) {
                    for (int k = j + 1; k < n; k++) {
                        maxValue = Math.max(
                                maxValue,
                                currDiff * nums[k]
                        );
                    }
                }
            }
        }
        return maxValue;
    }

    private static long maximumValue_Approach2(int[] nums) {
        long maxValue = 0;
        int n = nums.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
        }

        for (int k = 0; k < n; k++) {
            maxValue = Math.max(
                    maxValue,
                    (long) (leftMax[k] - nums[k]) * rightMax[k]
            );
        }
        return maxValue;
    }

    private static long maximumValue_Approach3(int[] nums) {
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
        System.out.println("Maximum value of an ordered triplet: " + maximumValue_Approach2(nums));
        System.out.println("Maximum value of an ordered triplet: " + maximumValue_Approach3(nums));
    }
}