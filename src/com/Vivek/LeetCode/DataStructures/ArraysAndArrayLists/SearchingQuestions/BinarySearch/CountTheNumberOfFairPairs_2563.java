package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class CountTheNumberOfFairPairs_2563 {
    private static int countFairPairs(int[] nums, int lower, int upper) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (lower <= sum && sum <= upper) {
                    result++;
                }
            }
        }

        return result;
    }

    private static int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static long countFairPairs_(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);

        long result = 0;

        for (int i = 0; i < n; i++) {
            int leftIdx = lowerBound(nums, i + 1, n, lower - nums[i]);
            int rightIdx = upperBound(nums, i + 1, n, upper - nums[i]);

            int x = leftIdx - 1 - i;
            int y = rightIdx - 1 - i;

            result += (y - x);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter the lower bound (lower): ");
        int lower = scanner.nextInt();

        System.out.print("Enter the upper bound (upper): ");
        int upper = scanner.nextInt();

        System.out.println("Number of fair pairs: " + countFairPairs(nums, lower, upper));
        System.out.println("Number of fair pairs: " + countFairPairs_(nums, lower, upper));
    }
}