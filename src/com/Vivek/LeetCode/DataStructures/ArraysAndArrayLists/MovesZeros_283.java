package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Arrays;
import java.util.Scanner;

public class MovesZeros_283 {
    private static void movesZeros(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        while (right < n) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }

            right++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        movesZeros(nums);
        System.out.println("Original array: " + Arrays.toString(nums));
    }
}
