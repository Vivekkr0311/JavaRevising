package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.HashMap;
import java.util.Scanner;

public class NextGreaterElementI_496 {
    private static int findNextGreater(int[] nums, int i, int num) {
        for (int k = i; k < nums.length; k++) {
            if (nums[k] > num) {
                return nums[k];
            }
        }
        return -1;
    }

    private static int[] nextGreaterElement(int[] nums1, int nums2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int nextGreaterIdx = map.get(nums1[i]) + 1;
            if (nextGreaterIdx < nums2.length) {
                int nextGreater = findNextGreater(nums2, nextGreaterIdx, nums1[i]);
                result[i] = nextGreater;
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the first array:");
        int n = scanner.nextInt();

        int[] nums1 = new int[n];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.println("Enter the size of the second array:");
        int m = scanner.nextInt();
        int[] nums2 = new int[m];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < m; i++) {
            nums2[i] = scanner.nextInt();
        }

        System.out.println("Next greater elements: " + java.util.Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}