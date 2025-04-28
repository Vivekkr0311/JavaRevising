package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class CountSubarraysWithScoreLessThanK_2302 {
    private static long countSubarrays_(int[] nums, int k) {
        long cnt = 0;
        int left = 0;
        long sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }

            cnt += (right - left + 1);
        }

        return cnt;
    }

    private static long countSubarrays(int[] nums, int k) {
        long count = 0;
        int left = 0;
        int right = 0;
        long sum = 0;
        int n = nums.length;

        while (right < n) {
            sum += nums[right];

            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }

            if (sum * (right - left + 1) < k) {
                count += (right - left + 1);
            }
            right++;
        }
        return count;
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

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Number of subarrays: " + countSubarrays(nums, k));
        System.out.println("Number of subarrays: " + countSubarrays_(nums, k));
    }
}
