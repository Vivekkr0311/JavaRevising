package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class ShortestSubarrayWithORAtLeastKI {
    private static int minimumSubarrayLength(int[] nums, int k){
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int currOr = nums[i];
           for(int j = i; j < nums.length; j++){
               currOr = currOr | nums[j];

               if(currOr >= k){
                   int currLength = j - i + 1;

                   if(currLength < ans){
                       ans = currLength;
                   }
               }
           }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Length of the subarray is: " + minimumSubarrayLength(nums, k));
    }
}
