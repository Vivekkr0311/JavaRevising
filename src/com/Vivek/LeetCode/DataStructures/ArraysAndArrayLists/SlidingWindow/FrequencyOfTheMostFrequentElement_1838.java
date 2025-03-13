package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class FrequencyOfTheMostFrequentElement_1838 {
    private static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        long sum = 0;

        while (right < n) {
            sum += nums[right];
            long cost = (long) nums[right] * (right - left + 1) - sum;

            while (cost > k) {
                sum -= nums[left];
                left++;
                cost = (long) nums[right] * (right - left + 1) - sum;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Length of the subarray with maximum frequency element after k operation: " + maxFrequency(nums, k));
    }
}
