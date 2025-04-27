package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class CountSubarraysofLengthThreeWithACondition_3392 {
    private static int countSubarrays(int[] nums) {
        int result = 0;
        int n = nums.length;
        for (int i = 0; i + 2 < n; i++) {
            int sum = nums[i] + nums[i + 2];

            if (2 * sum == nums[i + 1]) {
                result++;
            }
        }
        return result;
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

        System.out.println("Count of subarrays: " + countSubarrays(nums));
    }
}