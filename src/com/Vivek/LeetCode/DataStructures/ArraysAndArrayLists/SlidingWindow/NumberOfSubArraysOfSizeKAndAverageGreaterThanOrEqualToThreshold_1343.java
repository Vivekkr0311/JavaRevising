package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold_1343 {
    private static int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (right < arr.length) {
            sum += arr[right];

            if (right - left + 1 == k) {
                if (sum >= threshold * k) {
                    ans++;
                }

                sum -= arr[left];
                left++;
            }
            right++;
        }
        return ans;
    }

    private static int numOfSubarraysBruteForce(int[] arr, int k, int threshold) {
        int ans = 0;

        for (int left = 0; left <= arr.length - k; left++) {
            int sum = 0;

            for (int right = left; right < left + k; right++) {
                sum += arr[right];
            }

            // sum / k >= threshold => sum >= threshold * k
            if (sum >= threshold * k) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Enter threshold: ");
        int threshold = scanner.nextInt();

        System.out.println("Ans: " + numOfSubarraysBruteForce(arr, k, threshold));
        System.out.println("Ans: " + numOfSubarrays(arr, k, threshold));
    }
}
