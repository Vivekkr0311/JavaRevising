package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.MergeSort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortInPlace {

    static void mergeSortInPlace(int []arr, int start, int end){
        if((end - start) == 1){
            return ;
        }

        int mid = start + (end - start)/2;

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    static void mergeInPlace(int []arr, int start, int mid, int end){
        int []mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i < mid && j <  end){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j < end){
            mix[k] = arr[j];
            j++;
            k++;
        }

        for(int idx = 0; idx < mix.length; idx++){
            arr[start + idx] = mix[idx];
        }
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

        mergeSortInPlace(arr, 0 , n);
        System.out.println(Arrays.toString(arr));
    }
}
