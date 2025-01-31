package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class MissingNumberUsingBinarySearch {

    private static int missingNumber(int[] arr){
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length;

        while(start < end){
            int mid = start + ((end - start) >> 1);

            if(arr[mid] == mid){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements? between 0 to ?: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Insert each elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Missing number in: " + Arrays.toString(arr) + " is " + missingNumber(arr));
    }
}
