package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class CountSubarraysWithFixedBounds_2444 {
    private static long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minPosition = -1;
        int maxPosition = -1;
        int leftBound = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
            }

            if (nums[i] == minK) {
                minPosition = i;
            }

            if (nums[i] == maxK) {
                maxPosition = i;
            }

            int count = Math.min(minPosition, maxPosition) - leftBound;

            if (count > 0) {
                ans += count;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter min bound: ");
        int minK = scanner.nextInt();

        System.out.println("Enter max bound: ");
        int maxK = scanner.nextInt();

        System.out.println("Number of subarray within bounds: " + countSubarrays(nums, minK, maxK));
    }
}
