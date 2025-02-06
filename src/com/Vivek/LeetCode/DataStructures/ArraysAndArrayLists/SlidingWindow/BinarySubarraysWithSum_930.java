package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;
// https://leetcode.com/problems/binary-subarrays-with-sum/description/?envType=problem-list-v2&envId=sliding-window??

import java.util.HashMap;
import java.util.Scanner;

public class BinarySubarraysWithSum_930 {
    private static int numSubaraysWithSumSlidingWindow(int[] nums, int goal) {
        return slidingWindowHelper(nums, goal) - slidingWindowHelper(nums, goal - 1);
    }

    private static int slidingWindowHelper(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int l = 0;
        int r = 0;
        int n = nums.length;
        int res = 0;
        int sum = 0;

        while (r < n) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            res += r - l + 1;
            r++;
        }

        return res;
    }

    private static int numSubaraysWithSumSlidingWindow2(int[] nums, int goal) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int result = 0;
        int windowSum = 0;
        int countPrefixZeros = 0;

        while (j < n) {
            windowSum += nums[j];

            while (i < j && (nums[i] == 0 || windowSum > goal)) {
                if (nums[i] == 0) {
                    countPrefixZeros++;
                } else {
                    countPrefixZeros = 0;
                }
                windowSum -= nums[i];
                i++;
            }

            if (windowSum == goal) {
                result += 1 + countPrefixZeros;
            }
            j++;
        }
        return result;
    }

    private static int numSubaraysWithSum(int[] nums, int goal) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        map.put(0, 1);
        for (int i : nums) {
            sum += i;
            int a = sum - goal;

            if (map.containsKey(a)) {
                res += map.get(a);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    private static int numSubaraysWithSumBruteForce(int[] nums, int goal) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == goal) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the goal: ");
        int goal = scanner.nextInt();

        System.out.println("Number of subarrays with sum " + goal + " is " + numSubaraysWithSum(nums, goal));
        System.out.println("Number of subarrays with sum " + goal + " is " + numSubaraysWithSumBruteForce(nums, goal));
        System.out.println("Number of subarrays with sum " + goal + " is " + numSubaraysWithSumSlidingWindow(nums, goal));
        System.out.println("Number of subarrays with sum " + goal + " is " + numSubaraysWithSumSlidingWindow2(nums, goal));
    }
}
