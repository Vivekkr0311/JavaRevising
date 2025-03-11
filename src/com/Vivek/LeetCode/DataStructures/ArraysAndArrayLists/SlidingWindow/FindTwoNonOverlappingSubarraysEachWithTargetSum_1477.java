package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTwoNonOverlappingSubarraysEachWithTargetSum_1477 {
    public static int minSumOfLengthsWithDp(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int n = arr.length;
        int sum = 0;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int result = Integer.MAX_VALUE;
        int bestLength = Integer.MAX_VALUE;

        while (right < n) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int currLength = right - left + 1;

                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, currLength + dp[left - 1]);
                }

                bestLength = Math.min(bestLength, currLength);
            }

            dp[right] = bestLength;
            right++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }


    private static int minSumOfLengths(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int n = arr.length;
        int sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while (right < n) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int currLength = right - left + 1;
                minHeap.add(currLength);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        int size = minHeap.size();

        return !(size > 1) ? -1 : minHeap.poll() + minHeap.poll();
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
        System.out.println("Number of subarrays which are non-overlapping with target sum: " + minSumOfLengthsWithDp(nums, target));
    }
}