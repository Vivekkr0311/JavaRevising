package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOfTwoNonOverlappingSubarrays_1031 {
//    private static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
//        int res = 0;
//
//        int i = 0;
//        int j = i + firstLen - 1;
//        int n = nums.length;
//
//        while (j < n) {
//            int subarrayAtLeft = i + 1 < secondLen ? 0 : ((i - 1) + 1) - secondLen + 1;
//            int subarrayAtRight = (n - (j + 1)) < firstLen ? 0 : (n - (j + 1) + 1) - secondLen;
//            res += subarrayAtLeft + subarrayAtRight;
//            j++;
//            i++;
//        }
//
//        return res;
//    }

    private static int[] prefixSum(int[] nums, int k) {
        int windowSum = 0;
        int[] res = new int[nums.length];

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        res[k - 1] = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            int localMaxSum = Math.max(res[i - 1], windowSum);
            res[i] = localMaxSum;
        }
        return res;
    }

    private static int[] suffixSum(int[] nums, int k) {
        int windowSum = 0;
        int n = nums.length;
        int[] res = new int[n];

        for (int i = n - 1; i > (n - 1) - k; i--) {
            windowSum += nums[i];
        }
        res[n - k] = windowSum;

        for (int i = (n - 1) - k; i >= 0; i--) {
            windowSum = windowSum + nums[i] - nums[i + k];
            int localMaxSum = Math.max(res[i + 1], windowSum);
            res[i] = localMaxSum;
        }
        return res;
    }

    private static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] dp1 = prefixSum(nums, firstLen);
        int[] dp2 = suffixSum(nums, secondLen);

        int ans = 0;

        for (int i = firstLen - 1; i < nums.length - secondLen; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i + 1]);
        }

        dp1 = prefixSum(nums, secondLen);
        dp2 = suffixSum(nums, firstLen);

        for (int i = secondLen - 1; i < nums.length - firstLen; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i + 1]);
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of element: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter first length: ");
        int firstLen = scanner.nextInt();

        System.out.println("Enter second length: ");
        int secondLen = scanner.nextInt();

        System.out.println("Number of non-overlapping subarray: " + maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }
}
