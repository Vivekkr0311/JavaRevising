package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class LongestSubarrayOf1sAfterDeletingOneElement_1493 {
    private static int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ansLength = 0;
        int currLength = 0;
        int numberOfZeros = 0;

        while (right < n) {
            if (nums[right] == 0) {
                numberOfZeros += 1;

                while (numberOfZeros > 1) {
                    if (nums[left] == 0) {
                        numberOfZeros -= 1;
                    }
                    left++;
                }
            }
            currLength = right - left + 1;
            ansLength = Math.max(ansLength, currLength);
            right++;
        }
        return ansLength - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Number of longest subarray of 1s after one deletion " + longestSubarray(nums));
    }
}
