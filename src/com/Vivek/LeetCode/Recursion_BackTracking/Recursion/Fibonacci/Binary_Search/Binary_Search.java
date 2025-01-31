package com.Vivek.LeetCode.Recursion_BackTracking.Recursion.Fibonacci.Binary_Search;

import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int arr[] = { 4, 5, 7, 9, 100};
        System.out.println("Find anything from this:" + Arrays.toString(arr));
        int target = input.nextInt();
        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
    }

    static int binarySearch(int  []arr, int target, int start, int end){

        if(start > end){
            return -1;
        }

        int mid = start + (end - start)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(target < arr[mid]){
            return binarySearch(arr, target, start, mid - 1);
        }

        return binarySearch(arr, target, mid + 1, end);
    }
}
