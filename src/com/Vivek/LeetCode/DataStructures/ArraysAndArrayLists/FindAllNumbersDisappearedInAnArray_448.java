package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindAllNumbersDisappearedInAnArray_448 {
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                continue;
            }
            nums[idx] *= -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    private static List<Integer> findDisappearedNumbers_(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (freq[i + 1] == 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] nums2 = Arrays.copyOf(nums, n);
        System.out.println("The numbers that disappeared in the array are: " + findDisappearedNumbers(nums));
        System.out.println("The numbers that disappeared in the array are: " + findDisappearedNumbers_(nums2));
    }
}