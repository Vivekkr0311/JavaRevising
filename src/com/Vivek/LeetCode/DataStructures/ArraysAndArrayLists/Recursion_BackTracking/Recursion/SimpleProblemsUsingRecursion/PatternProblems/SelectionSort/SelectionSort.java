package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.PatternProblems.SelectionSort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

    static void selection(int []arr, int r, int c, int max){
        if(r == 0){
            return;
        }

        if(c < r){
            if(arr[c] > arr[max]){
                selection(arr, r, c+1, c);
            }else{
                selection(arr, r, c + 1, max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;

            selection(arr, r - 1, 0, 0);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Number of elements??");
        int n = input.nextInt();

        int []arr =  new int[n];
        System.out.println("Insert elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        selection(arr, n, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
}
