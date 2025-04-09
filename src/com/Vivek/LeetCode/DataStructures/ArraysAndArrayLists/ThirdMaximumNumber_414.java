package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Arrays;
import java.util.Scanner;

public class ThirdMaximumNumber_414 {
    private static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int largest = nums[n - 1];
        int count = 2;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != largest) {
                largest = nums[i];
                count--;
            }

            if (count == 0) {
                largest = nums[i];
                break;
            }
        }

        if(count > 0) {
            return nums[n - 1];
        }

        return largest;
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

        System.out.println("Third maximum number: " + thirdMax(nums));
    }
}
