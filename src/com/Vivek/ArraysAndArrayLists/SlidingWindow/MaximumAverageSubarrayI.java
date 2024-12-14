package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MaximumAverageSubarrayI {
    private static double findMaxAverage(int[] nums, int k){
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
