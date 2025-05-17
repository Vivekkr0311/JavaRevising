package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Sorting;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.copyOf;

public class SortColors_75 {
    private static void sortColors(int[] nums) {
        int cntZero = 0;
        int cntOne = 0;
        int cntTwo = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cntZero++;
            } else if (nums[i] == 1) {
                cntOne++;
            } else if (nums[i] == 2) {
                cntTwo++;
            }
        }

        int onesWall = cntZero + cntOne;
        int twosWall = onesWall + cntTwo;

        for (int i = 0; i < cntZero; i++) {
            nums[i] = 0;
        }

        for (int i = cntZero; i < onesWall; i++) {
            nums[i] = 1;
        }

        for (int i = onesWall; i < twosWall; i++) {
            nums[i] = 2;
        }
    }

    private static void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    private static void sortColors_(int[] nums) {
        int start = 0;
        int middle = 0;
        int end = nums.length - 1;

        while (middle <= end) {
            switch (nums[middle]) {
                case 0:
                    swap(nums, start, middle);
                    middle++;
                    start++;
                    break;
                case 1:
                    middle++;
                    break;
                case 2:
                    swap(nums, middle, end);
                    end--;
                    break;
            }
        }
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

        int[] nums2 = Arrays.copyOf(nums, nums.length);
        sortColors(nums);
        System.out.println("Sorted: " + Arrays.toString(nums));

        sortColors_(nums2);
        System.out.println("Sorted: " + Arrays.toString(nums));
    }
}