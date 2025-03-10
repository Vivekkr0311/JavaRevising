package com.Vivek.LeetCode.DynamicProgramming.KadanceAlgorithm;

import java.util.Scanner;

public class MaxSumSubarray {

    private static int maxSumSubarrayBruteforce(int[] nums) {
        int global_max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int local_max = 0;

            for (int j = i; j < nums.length; j++) {
                local_max += nums[j];
                global_max = Math.max(global_max, local_max);
            }
        }
        return global_max;
    }

    private static int kadanceAlgorithmMaxSumSubArray(int[] nums) {
        int max_so_far = nums[0];
        int curr_max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr_max = Math.max(nums[i], nums[i] + curr_max);
            max_so_far = Math.max(curr_max, max_so_far);
        }
        return max_so_far;
    }

    private static int kadance(int[] nums) {
        int global_sum = nums[0];
        int curr_sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (curr_sum + nums[i] > nums[i]) {
                curr_sum += nums[i];
            } else {
                curr_sum = nums[i];
            }

            if (curr_sum > global_sum) {
                global_sum = curr_sum;
            }
        }

        return global_sum;
    }

//    private static int kadanceAlgorithmMaxSumSubArray(int[] nums) {
//        int csum = nums[0];
//        int osum = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            if (csum >= 0) {
//                csum += nums[i];
//            } else {
//                csum = nums[i];
//            }
//
//            if (csum > osum) {
//                osum = csum;
//            }
//        }
//        return osum;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Max sum subarray: " + maxSumSubarrayBruteforce(nums));
        System.out.println("Max sum subarray: " + kadanceAlgorithmMaxSumSubArray(nums));
        System.out.println("Max sum subarray: " + kadance(nums));
    }
}
