package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.PatternProblems.BubbleSort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    static void bubble(int []arr, int row, int col){
        if(row == 0){
            return;
        }

        if(row > col){
            if(arr[col] > arr[col + 1]){
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }

            bubble(arr, row, col + 1);
        }else{
            bubble(arr, row - 1, 0);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert number of elements: ");
        int n = input.nextInt();

        int []arr = new int[n];

        System.out.println("Insert each elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        bubble(arr, n - 1, 0);
        System.out.println(Arrays.toString(arr));
    }
}
