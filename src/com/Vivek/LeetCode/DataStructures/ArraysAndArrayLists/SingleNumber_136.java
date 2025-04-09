package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Arrays;
import java.util.Scanner;

public class SingleNumber_136 {
    private static int singleNumber(int[] nums) {
        int n = nums.length - 1;
        if (n == 0) {
            return nums[0];
        }

        Arrays.sort(nums);
        for (int i = n; i >= 0; i--) {
            if (i == n && nums[i] != nums[i - 1]) {
                return nums[i];
            } else if (i == 0 && nums[i] != nums[i + 1]) {
                return nums[i];
            } else if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    private static int singleNumber_(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Single number in the array: " + singleNumber(nums));
        System.out.println("Single number in the array: " + singleNumber_(nums));
    }
}
