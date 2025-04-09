package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumOperationsToMakeArrayValuesEqualToK_3375 {
    private static int minOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int minOperations = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > k) {
                int temp = nums[i];

                while (i >= 0 && nums[i] == temp) {
                    i--;
                }
                i++;
                minOperations++;
            } else if (nums[i] < k) {
                minOperations = -1;
                break;
            }
        }

        return minOperations;
    }

    private static int minOperations_(int[] nums, int k) {
        Arrays.sort(nums);
        int i = nums.length - 1;
        int minOperations = 0;
        while (i >= 0) {
            if (nums[i] > k) {
                int temp = nums[i];

                while (i >= 0 && nums[i] == temp) {
                    i--;
                }
                minOperations++;
            } else if (nums[i] < k) {
                return -1;
            } else {
                i--;
            }
        }

        return minOperations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        System.out.println("Minimum operations to make all elements equal to " + k + ": " + minOperations(arr, k));
        System.out.println("Minimum operations to make all elements equal to " + k + ": " + minOperations_(arr, k));
    }
}
