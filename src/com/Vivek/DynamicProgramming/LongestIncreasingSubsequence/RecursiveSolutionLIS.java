package com.Vivek.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
public class RecursiveSolutionLIS {

    static int findMax(int[] list){
        int max = list[0];
        for(int num : list){
            if(num > max){
                max = num;
            }
        }
        return max;
    }

    static int[] helper(int[] arr, int[] list, int i, int j){
        if(i == j){
            return list;
        }

        if(arr[i] > arr[j]){
            list[i] = Math.max(list[j]+ 1, list[i]);
            helper(arr, list, i, j + 1);
        }
        return list;
    }

    
    static int[] recursiveLIS(int[] arr, int[] currLIS, int i){
        // DP solution converted into a recursion solution.
        if(i == arr.length){
            return currLIS;
        }

        currLIS = helper(arr, currLIS, i, 0);
        return recursiveLIS(arr, currLIS, i + 1);
    }

    static int recursiveLISDP(int[] arr){
        // Usual DP solution
        int[] list = new int[arr.length];
        for(int i = 0; i < list.length; i++){
            list[i] = 1;
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j <= i; j++){
                if(arr[j] < arr[i]){
                    list[i] = Math.max(list[j] + 1, list[i]);
                }
            }
        }

        int max = list[0];
        for(int i = 1; i < list.length; i++){
            if(list[i] > max){
                max = list[i];
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

        int[] currList = new int[n];
        for(int i = 0; i < currList.length; i++){
            // filling the memoization table beforehand with default values
            // representing each element with LIS 1 for that particular element.
            currList[i] = 1;
        }
        currList = recursiveLIS(arr, currList, 0);
        System.out.println("LIS: " + findMax(currList));
    }
}
