package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MaximumAverageSubarrayI {
    private static double findMaxAverageBruteForce(int[] nums, int k){
        double avg = Double.NEGATIVE_INFINITY;

        for(int i = 0; i + k <= nums.length; i++){
            int sum = 0;
            for(int j = i; j < i + k; j++){
                sum += nums[j];
            }

            double newAvg = (double) sum / k;
            avg = Math.max(avg, newAvg);
        }
        return avg;
    }

    private static double findMaxAverage(int[] nums, int k){
        double avg = Double.NEGATIVE_INFINITY;

        int sum = 0;
        if(k <= nums.length){
            for(int i = 0; i < k; i++){
                sum += nums[i];
            }
        }
        avg = (double) sum / k;

        int left = 0;
        int right = k;

        while(right < nums.length){
            sum = sum - nums[left];
            sum = sum + nums[right];
            double newAvg = (double) sum / k;
            avg = Math.max(avg, newAvg);
            left++;
            right++;
        }
        return avg;
    }

    private static double findMaxAverageMostEfficient(int[] nums, int k){
        int sum = 0;
        if(k <= nums.length){
            for(int i = 0; i < k; i++){
                sum += nums[i];
            }
        }
        int maxSum = sum;
        int left = 0;
        int right = k;

        while(right < nums.length){
            sum = sum - nums[left];
            sum = sum + nums[right];
            maxSum = Math.max(maxSum, sum);
            left++;
            right++;
        }
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scanner.nextByte();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Maximum average: " + findMaxAverage(nums, k));
    }
}
