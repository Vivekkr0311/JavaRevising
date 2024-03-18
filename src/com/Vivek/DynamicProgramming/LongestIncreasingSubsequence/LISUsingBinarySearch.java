package com.Vivek.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LISUsingBinarySearch {

    // This solution take O(n * log(n)) time
    static int ceil(int[] arr, int start, int end, int num){

        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] >= num){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }

    static int lisBS(int[] arr){
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] < arr[i]){
                list.add(arr[i]);
            }else{
                int idx = ceil(arr, 0, i, arr[i]);
                list.set(idx, arr[i]);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = input.nextInt();
//        Enter the number of elements:
//        7
//        3 4 2 8 10 5 1
        int[] arr = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Longest increasing subsequence can be of length: " + lisBS(arr));
    }
}
