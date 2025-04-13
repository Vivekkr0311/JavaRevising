package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MaxConsecutiveOnes_485 {
    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;

        while (right < n) {
            if (nums[right] == 0) {
                left = right + 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter the elements of the array (0s and 1s only): ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Maximum number of consecutive 1s: " + findMaxConsecutiveOnes(nums));
    }
}