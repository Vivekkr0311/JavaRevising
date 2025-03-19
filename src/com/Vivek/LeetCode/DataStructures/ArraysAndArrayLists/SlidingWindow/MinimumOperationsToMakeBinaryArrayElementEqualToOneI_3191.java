package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MinimumOperationsToMakeBinaryArrayElementEqualToOneI_3191 {
    private static void flipWindow(int[] nums, int position) {
        nums[position] ^= 1;
        nums[position + 1] ^= 1;
        nums[position + 2] ^= 1;
    }

    private static int minOperations(int[] nums) {
        int n = nums.length;
        int right = 0;
        int count = 0;

        while (right < n - 2) {
            if (nums[right] != 1) {
                flipWindow(nums, right);
                count++;
            }
            right++;
        }

        if (nums[n - 2] == 0 || nums[n - 1] == 0) {
            return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Minimum number of operations to make all 1s is: " + minOperations(nums));
    }
}
