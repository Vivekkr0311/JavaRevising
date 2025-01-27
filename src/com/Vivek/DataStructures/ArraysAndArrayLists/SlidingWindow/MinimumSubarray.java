package com.Vivek.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MinimumSubarray {

    static int minimumSubArray(int[] arr, int target){
        int R = 0;
        int L = 0;

        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(R < arr.length){
            sum += arr[R];

            while(target <= sum){
                min = Math.min(min, R - L + 1);
                sum -= arr[L];
                L++;
            }
            R++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n  = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter each elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Enter the sum: ");
        int sum = input.nextInt();
        System.out.println("Ans: " + minimumSubArray(arr, sum));
    }
}
