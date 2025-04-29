package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes_2962 {
    private static long countSubarrays(int[] nums, int k) {
        long cnt = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        int max_count = 0;

        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }

        while (right < n) {
            if (nums[right] == max) {
                max_count++;
            }

            while (max_count >= k) {
                cnt += 1 + (n - (right + 1)); // 1 + (n - (right + 1) => 1 + n - right -1 => (n - right)
                if (nums[left] == max) {
                    max_count--;
                }
                left++;
            }

            right++;
        }

        return cnt;
    }

    private static long countSubarrays_(int[] nums, int k) {
        long cnt = 0;
        int left = 0;
        int n = nums.length;
        int max_count = 0;

        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }

        for (int right = 0; right < n; right++) {
            if (nums[right] == max) {
                max_count++;
            }

            while (max_count >= k) {
                cnt += (n - right);
                if (nums[left++] == max) {
                    max_count--;
                }
            }
        }

        return cnt;
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

        System.out.println("Number of subarray containing max: " + k + " max elements are: " + countSubarrays(nums, k));
        System.out.println("Number of subarray containing max: " + k + " max elements are: " + countSubarrays_(nums, k));
    }
}