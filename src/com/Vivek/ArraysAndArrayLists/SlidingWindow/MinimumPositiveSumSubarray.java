package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumPositiveSumSubarray {
    private static int getCurrentSubarraySum(List<Integer> nums, int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += nums.get(i);
        }
        return sum;
    }

    private static int minimumSumSubarray(List<Integer> nums, int l, int r){
        int n = nums.size();

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
           for(int j = i; j < n; j++){
               int currLength = j - i + 1;
               if(currLength >= l && currLength <= r){
                   int sum = getCurrentSubarraySum(nums, i, j);

                   if(sum > 0 && sum <= ans){
                       ans = sum;
                   }
               }
           }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            nums.add(scanner.nextInt());
        }

        System.out.println("Enter l: ");
        int l = scanner.nextInt();

        System.out.println("Enter r: ");
        int r = scanner.nextInt();

        System.out.println("Minimum sum of subarray whose length is between " + l + " and " + r + " is:  " + minimumSumSubarray(nums, l, r));
    }
}
