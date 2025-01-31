package com.Vivek.LeetCode.Iteration.Sorting.SelectionSort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

    static void selectionSort(int []arr){
        for(int i = 0; i < arr.length; i++){
            int size = arr.length - i - 1;
            int max = getMaxElement(arr, size);

            swap(arr, max, size);
        }
    }

    static void swap(int []arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int getMaxElement(int []arr, int size){
        int max = 0;
        for(int i = 0; i <= size; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }

        return max;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert n: ");

        int n = input.nextInt();
        int []arr = new int[n];

        System.out.println("Insert elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
