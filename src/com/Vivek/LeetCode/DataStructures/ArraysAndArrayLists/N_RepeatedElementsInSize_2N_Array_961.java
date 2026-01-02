package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class N_RepeatedElementsInSize_2N_Array_961 {
    private static int repeatedNTimes(int[] nums) {
        int ans = 0;
        int expectedCount = nums.length >> 1;
        int[] count = new int[10000];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (count[nums[i]] == expectedCount) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    private static int wrapIndex(int index, int n) {
        return (index % n + n) % n;
    }

    // repeated element always appears either in (i - 1) or (i - 2) position
    private static int repeatedNTimesOptimized(int[] nums) {
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i - 1] || nums[i] == nums[i - 2]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements (2N): ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("The element repeated N times is: " + repeatedNTimes(nums));
        System.out.println("The element repeated N times is: " + repeatedNTimesOptimized(nums));
    }
}
