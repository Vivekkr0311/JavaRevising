package com.Vivek.LeetCode.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.Scanner;

public class LongestIncSubsequence {

    static int longestIncSubsequence(int[] arr){
        int[] lis = new int[arr.length];

        lis[0] = 1;

        for(int i = 1; i < arr.length; i++){
            lis[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        int max = lis[0];
        for(int i = 1; i < lis.length; i++){
            if(lis[i] > max){
                max = lis[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = input.nextInt();
        int[] arr = new int[n];
//        Enter the number of elements:
//        7
//        3 4 2 8 10 5 1
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Longest increasing subsequence can be of length: " + longestIncSubsequence(arr));
    }
}
