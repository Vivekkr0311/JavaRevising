package com.Vivek.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.MergeSort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    static int[] mergeSort(int []arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;
        int []left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int []right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int []merge(int []left, int []right){
        int [] arr = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }

            k++;
        }

        while(i < left.length){
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length){
            arr[k] = right[j];
            j++;
            k++;
        }

        return arr;
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

        int []ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }
}
