package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindKClosestElements {
    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        if (k == 0 || k > n) {
            return ans;
        }

        int left = 0;
        int right = n - 1;

        while (right - left + 1 > k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
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
