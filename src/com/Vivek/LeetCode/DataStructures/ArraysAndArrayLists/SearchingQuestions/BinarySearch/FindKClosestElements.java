package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindKClosestElements {
    private static int binarySearch(int[] arr, int n, int x, int k) {
        int start = 0;
        int end = n - k;

        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (x - arr[mid] > arr[mid + k] - x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        if (k == 0 || k > n) {
            return ans;
        }

        int left = binarySearch(arr, n, x, k);
        int right = left + k;

        for (int i = left; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();
        System.out.println("Enter x: ");
        int x = scanner.nextInt();

        System.out.println(k + " closest elements of " + x + " are " + findClosestElements(nums, k, x));
    }
}
