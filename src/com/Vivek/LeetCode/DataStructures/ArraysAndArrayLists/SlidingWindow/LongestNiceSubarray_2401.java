package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class LongestNiceSubarray_2401 {
    private static int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        int bitMask = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left];
                left++;
            }
            bitMask |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Longset Nice Subarray: " + longestNiceSubarray(nums));
    }
}
