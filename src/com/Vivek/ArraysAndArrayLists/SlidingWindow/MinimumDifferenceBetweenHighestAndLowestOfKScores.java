package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    private static int minimumDifferenceBruteForce(int[] nums, int k){
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
    }
}
