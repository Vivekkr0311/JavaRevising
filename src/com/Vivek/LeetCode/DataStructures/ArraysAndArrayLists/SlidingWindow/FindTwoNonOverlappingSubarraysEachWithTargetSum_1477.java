package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class FindTwoNonOverlappingSubarraysEachWithTargetSum_1477 {
    private static int minSumOfLengths(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int n = arr.length;
        int ans = 0;
        int sum = 0;

        while (right < n) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                ans++;
                left = right + 1;
                sum = 0;
            }
            right++;
        }

        return !(ans > 1) ? -1: ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter target: ");
        int target = scanner.nextInt();

        System.out.println("Number of subarrays which are non-overlapping with target sum: " + minSumOfLengths(nums, target));
    }
}
