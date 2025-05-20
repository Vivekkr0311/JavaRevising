package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Arrays;
import java.util.Scanner;

public class ZeroArrayTransformationI_3355 {
    private static boolean isZeroArray(int[] nums, int[][] queries) {
        for (int[] i : queries) {
            int start = i[0];
            int end = i[1];

            for (int j = start; j <= end; j++) {
                if (nums[j] != 0) {
                    nums[j] = nums[j] - 1;
                }
            }
        }

        for (int i : nums) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isZeroArray_(int[] nums, int[][] queries) {
        int n = nums.length;

        // Step 1: Make difference array using queries
        int[] diff = new int[n];
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int x = 1;

            diff[start] += x;
            if (end + 1 < n) {
                diff[end + 1] -= x;
            }
        }

        // Step 2: Compute cumulative effect on each index
        int[] result = new int[n];
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += diff[i];
            result[i] = cumSum;
        }

        // Step 3: Check if each value can reach 0
        for (int i = 0; i < n; i++) {
            if (result[i] < nums[i]) {
                return false; // nums[i] won't become 0
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Number of queries: ");
        int q = scanner.nextInt();

        System.out.println("Enter queries: ");
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
        }

        System.out.println("Result: " + isZeroArray(nums, queries));
        System.out.println("Result: " + isZeroArray_(nums, queries));
    }
}
