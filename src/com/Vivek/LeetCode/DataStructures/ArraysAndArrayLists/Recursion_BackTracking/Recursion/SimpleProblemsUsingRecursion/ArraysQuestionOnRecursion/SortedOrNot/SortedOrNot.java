package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.ArraysQuestionOnRecursion.SortedOrNot;

import java.util.Scanner;

public class SortedOrNot {

    static boolean isSorted(long[] arr, int idx){
        if(idx == arr.length - 1){
            return true;
        }

        return arr[idx] <= arr[idx + 1] && isSorted(arr, idx + 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Number of elements? ");
        int numberOfElements = input.nextInt();
        long[] arr = new long[numberOfElements];

        System.out.println("Insert elements: ");

        for (int i = 0; i < numberOfElements; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Is array sorted: " + isSorted(arr, 0));
    }
}
