package com.Vivek.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class CountTheNumberOfIncremovableSubarrays {
    private static boolean isIncreasing(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int incremovableSubarrayCount(int[] nums){
        int n = nums.length;
        int count = 0;

        // Generate all possible subarrays
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                // Create the remaining array after removing the subarray [start, end]
                int[] remainingArray = new int[n - (end - start + 1)];
                int idx = 0;

                // Add the left part
                for (int i = 0; i < start; i++) {
                    remainingArray[idx++] = nums[i];
                }
                // Add the right part
                for (int i = end + 1; i < n; i++) {
                    remainingArray[idx++] = nums[i];
                }

                // Check if the remaining array is strictly increasing
                if (isIncreasing(remainingArray)) {
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Number of incremovable sub-arrays is: " + incremovableSubarrayCount(nums));
    }
}
