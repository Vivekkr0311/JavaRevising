package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArray_88 {
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];

        int left = 0;
        int right = 0;
        int k = 0;

        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                temp[k] = nums1[left];
                left++;
            } else {
                temp[k] = nums2[right];
                right++;
            }
            k++;
        }

        while (left < m) {
            temp[k] = nums1[left];
            left++;
            k++;
        }

        while (right < n) {
            temp[k] = nums2[right];
            right++;
            k++;
        }

        // for leetcode submission
        for (int i = 0; i < m + n; i++) {
            nums1[i] = temp[i];
        }

        return temp;
    }

    private static void merge_(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;

        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[last] = nums1[i];
                i--;
            } else {
                nums1[last] = nums2[j];
                j--;
            }
            last--;
        }

        while (j >= 0) {
            nums1[last] = nums2[j];
            last--;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of first array: ");
        int n1 = scanner.nextInt();

        int[] nums1 = new int[n1];
        System.out.println("Enter each element of first array (sorted): ");
        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.println("Enter length of second array: ");
        int n2 = scanner.nextInt();

        int[] nums2 = new int[n2];
        System.out.println("Enter each element of second array (sorted): ");
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }

        merge_(nums1, n1, nums2, n2);
        System.out.println("After merge: " + nums1);
    }
}