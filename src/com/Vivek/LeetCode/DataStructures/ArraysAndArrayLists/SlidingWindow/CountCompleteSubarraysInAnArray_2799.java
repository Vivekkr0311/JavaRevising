package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class CountCompleteSubarraysInAnArray_2799 {
    private static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int total_distinct_elements = 0;
        int[] map = new int[2001];

        for (int i = 0; i < n; i++) {
            if (map[nums[i]]++ == 0) {
                total_distinct_elements++;
            }
        }

        int left = 0;
        int right = 0;
        int result = 0;
        map = new int[2001];
        int window_distinct_element_count = 0;
        while (right < n) {
            if (map[nums[right]]++ == 0) {
                window_distinct_element_count++;
            }

            while (window_distinct_element_count == total_distinct_elements) {
                result += n - (right + 1) + 1;
                if(--map[nums[left]] == 0){
                    window_distinct_element_count--;
                }
                left++;
            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Total number of subarray having same number of distinct elements as the whole array is: " + countCompleteSubarrays(nums));
    }
}