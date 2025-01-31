package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

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

    private static boolean isIncreasing(int[] nums, int start, int end){
        for (int i = start; i + 1 <= end; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }


    private static int incremovableSubarraysCountApproach1(int[] nums){
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

    private static int incremovableSubarraysCountApproach2(int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(isIncreasing(nums, i, j)){
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

        System.out.println("Number of incremovable sub-arrays is: " + incremovableSubarraysCountApproach1(nums));
        System.out.println("Number of incremovable sub-arrays is: " + incremovableSubarraysCountApproach2(nums));
    }
}
