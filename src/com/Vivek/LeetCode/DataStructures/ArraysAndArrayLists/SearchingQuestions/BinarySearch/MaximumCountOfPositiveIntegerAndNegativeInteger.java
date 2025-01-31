package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    private static int searchPositive(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        int positiveIdx = -1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(nums[mid] <= 0){
                start = mid + 1;
            }else if(nums[mid] > 0){
                positiveIdx = mid;
                end = mid - 1;
            }
        }

        return positiveIdx;
    }

    private static int searchNegative(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        int negativeIdx = -1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(nums[mid] < 0){
                negativeIdx = mid;
                start = mid + 1;
            }else if(nums[mid] >= 0){
                end = mid - 1;
            }
        }

        return negativeIdx;
    }

    private static int maximumCount(int[] nums){
        if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            return 0; // No positives or negatives
        }

        int positiveIdx = searchPositive(nums);
        int positiveCount = positiveIdx == -1 ? 0 : nums.length - positiveIdx;

        int negativeIdx = searchNegative(nums);
        int negativeCount = negativeIdx == -1 ? 0 : negativeIdx + 1;

        return Math.max(positiveCount, negativeCount);
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

        System.out.println("Maximum of count of negative and positive integer is: " + maximumCount(nums));
    }
}
