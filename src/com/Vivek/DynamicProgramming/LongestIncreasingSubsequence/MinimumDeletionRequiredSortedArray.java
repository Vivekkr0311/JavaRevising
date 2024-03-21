package com.Vivek.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumDeletionRequiredSortedArray {

    static int ceil(List<Integer> list, int start, int end, int target){

        while(start < end){
            int mid = start + (end - start)/2;
            if(list.get(mid) >= target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }

    static int minimumDeletionRequired(int[] arr){
        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > list.get(list.size() - 1)){
                list.add(arr[i]);
            }else{
                int idx = ceil(list, 0, list.size() - 1, arr[i]);
                list.set(idx, arr[i]);
            }
        }

        return list.size() - arr.length < 0 ? (-1)*(list.size() - arr.length):list.size() - arr.length;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter each elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Minimum number of deletion required for making array sorted is: " + minimumDeletionRequired(arr));
    }
}
