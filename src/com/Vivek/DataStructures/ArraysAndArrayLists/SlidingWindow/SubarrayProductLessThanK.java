package com.Vivek.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class SubarrayProductLessThanK {
    private static int numSubarrayProductLessThanK(int[] nums, int k){
        if(k <= 1){
            return 0;
        }
        int ans = 0;
        int product = 1;

        int left = 0;
        int right = left;

        while(right < nums.length){
            product = product * nums[right];

            while(product >= k){
                product = product / nums[left];
                left++;
            }

            ans = ans + right - left + 1;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the k: ");
        int k = scanner.nextInt();


        System.out.println("NUmber of subarray having product less than " + k + " is " + numSubarrayProductLessThanK(nums, k));
    }
}
