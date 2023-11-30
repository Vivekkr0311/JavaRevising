package com.Vivek.Iteration.Sorting.BubbleSort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    static void bubble(int []arr, int n){
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
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
