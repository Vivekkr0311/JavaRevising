package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    private static int minimumDifferenceBruteForce(int[] nums, int k){
        // 98 % fast
        Arrays.sort(nums);

        int left = 0;
        int right = k - 1;

        int globalMin = Integer.MAX_VALUE;
        while(right < nums.length){
            int currDiff = Math.abs(nums[left] - nums[right]);
            globalMin = Math.min(currDiff, globalMin);
            left++;
            right++;
        }
        return globalMin;
    }

    private static int minimumDifference(int[] nums, int k){
        // 100 % fast
        Arrays.sort(nums);

        int left = 0;
        int globalMin = Integer.MAX_VALUE;
        for(int right = k - 1; right < nums.length; right++){
            int localDiff = nums[right] - nums[left++];
            if(localDiff < globalMin){
                globalMin = localDiff;
            }
        }
        return globalMin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements ?");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Minimum of different of " + k + " students in " + Arrays.toString(nums) + " is " + minimumDifferenceBruteForce(nums, k));
        System.out.println("Minimum of different of " + k + " students in " + Arrays.toString(nums) + " is " + minimumDifference(nums, k));
    }
}
