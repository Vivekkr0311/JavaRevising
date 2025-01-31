package com.Vivek.LeetCode.Iteration.Sorting.BubbleSort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    static void bubble(int []arr, int n){
        boolean swapped;

        for(int i = 0; i < n; i++){
            swapped = false;
            for(int j = 1; j < n - i; j++){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert number of elements: ");
        int n = input.nextInt();

        int []arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        bubble(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
