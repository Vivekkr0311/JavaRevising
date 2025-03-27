package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.BoyerMoore;

import java.util.Scanner;

public class MajorityElement_169 {
    private static int boyerMooreAlgorithm(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else if (count == 0) {
                candidate = nums[i];
                count++;
            } else if (candidate != nums[i]) {
                count--;
            }
        }
        return candidate;
    }

    private static int majorityElement(int[] nums) {
        int candidate = boyerMooreAlgorithm(nums);

        // below is verification part, it is not required in this problem
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            }
        }

        if (2 * count > nums.length) {
            return candidate;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers ? ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each number: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Majority number is: " + boyerMooreAlgorithm(nums));
    }
}
