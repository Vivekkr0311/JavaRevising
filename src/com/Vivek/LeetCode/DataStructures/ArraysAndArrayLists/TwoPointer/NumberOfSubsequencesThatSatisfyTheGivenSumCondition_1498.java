package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition_1498 {
    private static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        int left = 0;
        int right = n - 1;
        int mod = 1_000_000_007;

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
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

        System.out.println("Enter target: ");
        int target = scanner.nextInt();

        System.out.println("Result: " + numSubseq(nums, target));
    }
}