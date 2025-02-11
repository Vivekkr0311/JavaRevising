package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class Maximum_Sum_Subarray_of_Size_K_GFG {
    private static int maximumSumSubarray(int[] arr, int k) {
        int i = 0;
        int j = i + k;
        int n = arr.length;

        int window_sum = 0;


        for (int idx = 0; idx < k; idx++) {
            window_sum += arr[idx];
        }

        int sum = window_sum;
        while (j < n) {
            window_sum = window_sum + arr[j] - arr[j - k];
            sum = Math.max(sum, window_sum);
            j++;
        }
        return sum;
    }

    private static int maximumSumSubarray2(int[] arr, int k) {
        int j = 0;
        int n = arr.length;

        int window_sum = 0;
        int sum = window_sum;
        while (j < n) {
            if (j < k) {
                window_sum += arr[j];
            } else {
                window_sum = window_sum + arr[j] - arr[j - k];
            }
            sum = Math.max(sum, window_sum);
            j++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Maximum sum of subarray size " + k + " is " + maximumSumSubarray(arr, k));
    }
}
