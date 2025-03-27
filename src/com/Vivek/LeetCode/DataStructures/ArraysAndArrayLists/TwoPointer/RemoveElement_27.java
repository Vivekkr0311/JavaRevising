package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.TwoPointer;

import java.util.Scanner;

public class RemoveElement_27 {
    private static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter val: ");
        int val = scanner.nextInt();
        System.out.println("Till " + removeElement(nums, val) + " length, there are no " + val + "'s");
    }
}