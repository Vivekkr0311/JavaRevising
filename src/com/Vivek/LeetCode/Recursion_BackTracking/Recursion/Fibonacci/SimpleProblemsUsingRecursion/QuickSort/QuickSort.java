package com.Vivek.LeetCode.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.QuickSort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    static void quickSort(int []arr, int low, int high){
        if(low >= high){
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start)/2;

        int pivot = arr[mid];

        while(start <= end){
            while(arr[start] < pivot){
                start++;
            }

            while(arr[end] > pivot){
                end--;
            }

            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert length: ");

        int n =  input.nextInt();

        int []arr = new int[n];
        System.out.println("Insert elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        quickSort(arr, 0 , n - 1);
        System.out.println(Arrays.toString(arr));
    }
}
