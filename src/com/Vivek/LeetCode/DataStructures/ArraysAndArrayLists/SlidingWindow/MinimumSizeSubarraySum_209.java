package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MinimumSizeSubarraySum_209 {
    private static int search(int[] nums, int start, int end, int target) {
        int ans = -1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (nums[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int minSubArrayLen(int target, int[] nums) {
        // Binary search approach, but I think this question is most suited for sliding window
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int targetSum = target + (i > 0 ? prefix[i - 1] : 0);
            int searchIdx = search(prefix, i, nums.length - 1, targetSum);

            if (searchIdx != -1) {
                minLen = Math.min(minLen, searchIdx - i + 1);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private static int minSubArrayLenBruteForce(int target, int[] nums) {
        int ansLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int local_sum = 0;
            for (int j = i; j < nums.length; j++) {
                local_sum += nums[j];

                if (local_sum >= target) {
                    if (ansLength > j - i + 1) {
                        ansLength = j - i + 1;
                    }
                }
            }
        }

        return ansLength == Integer.MAX_VALUE ? 0 : ansLength;
    }

    private static int minSubArrayLenSlidingWindow(int target, int[] nums) {
        int ansLength = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int n = nums.length;
        int currSum = 0;

        while (j < n) {
            currSum += nums[j];

            while (currSum >= target) {
                ansLength = Math.min(ansLength, j - i + 1);
                currSum -= nums[i];
                i++;
            }
            j++;
        }
        return ansLength == Integer.MAX_VALUE ? 0 : ansLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the target: ");
        int target = scanner.nextInt();

        System.out.println("Minimum subarray size is: " + minSubArrayLen(target, nums));
        System.out.println("Minimum subarray size is: " + minSubArrayLenBruteForce(target, nums));
        System.out.println("Minimum subarray size is: " + minSubArrayLenSlidingWindow(target, nums));
    }
}
