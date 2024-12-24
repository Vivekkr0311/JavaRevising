package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class LongestEvenOddSubarrayWithThreshold {
    private static int longestAlternatingSubarray(int[] nums, int threshold){
        int ans = 0;

        for (int left = 0; left < nums.length; left++) {
            boolean condition1 = nums[left] % 2 == 0;
            boolean condition3 = nums[left] <= threshold;

            if (condition1 && condition3) {
                for (int right = left; right < nums.length; right++) {
                    boolean condition2 = (right == left) || (nums[right] % 2 != nums[right - 1] % 2);
                    boolean condition4 = nums[right] <= threshold;

                    if (condition1 && condition2 && condition4) {
                        int currLength = right - left + 1;
                        if(currLength > ans){
                            ans = currLength;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the threshold: ");
        int threshold = scanner.nextInt();


        System.out.println("Maximum subarray which satisfies the condition is: " + longestAlternatingSubarray(nums, threshold));
    }
}
