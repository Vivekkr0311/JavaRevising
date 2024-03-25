package com.Vivek.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.Scanner;
public class MaximumLegnthBitonicSubsequence {

    // Bitonic subsequence: A bitonic subsequence of a sequence of elements
    // is a sequence that first increases and then decreases,
    // or alternatively, first decreases and then increases

    static int bitoniceLength(int[] arr){
        int[] maximumInc = new int[arr.length];
        int[] maximumDec = new int[arr.length];
        int[] diffArray = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            maximumInc[i] = 1;
            maximumDec[i] = 1;
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    maximumInc[i] = Math.max(maximumInc[i], maximumInc[j] + 1);
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i]){
                    maximumDec[i] = Math.max(maximumDec[i], maximumDec[j] + 1);
                }
            }
        }

        int ans = maximumInc[0] + maximumDec[0] - 1;
        for(int i = 1; i < arr.length; i++){
            diffArray[i] = maximumInc[i] + maximumDec[i] - 1;
            if(diffArray[i] > ans){
                ans = diffArray[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Longest length of bitonic subsequnce: " + bitoniceLength(arr));
    }
}
