package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class CountNumberOfNiceSubarrays_1248 {
    private static int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int i = 0;
        int j = 0;
        int numberOfOdd = 0;
        int count = 0;
        int n = nums.length;

        while (j < n) {
            if ((nums[j] & 1) != 0) {
                numberOfOdd++;
                count = 0;
            }

            while (numberOfOdd == k) {
                if ((nums[i] & 1) != 0) {
                    numberOfOdd--;
                }
                count++;
                i++;
            }

            ans += count;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Number of nice subarrays is: " + numberOfSubarrays(nums, k));
    }
}
