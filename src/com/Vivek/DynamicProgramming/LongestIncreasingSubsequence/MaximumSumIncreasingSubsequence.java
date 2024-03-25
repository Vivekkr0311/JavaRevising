package com.Vivek.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumIncreasingSubsequence {

    static int maximumSumIncreasingSubsequence(int[] arr){
        int[] maximumSum = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            maximumSum[i] = arr[i];
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    maximumSum[i] = Math.max(maximumSum[i], maximumSum[j] + arr[i]);
                }
            }
        }

        System.out.println(Arrays.toString(maximumSum));
        int max = maximumSum[0];
        for(int i = 0; i < maximumSum.length; i++){
            if(maximumSum[i] > max){
                max = maximumSum[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = input.nextInt();
        System.out.println("Enter each elements: ");
        //        Enter the number of elements:
//        7
//        3 4 2 8 10 5 1
        // OP: 4
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Maximum Sum of increasing subsequence: " + maximumSumIncreasingSubsequence(arr));
    }
}
