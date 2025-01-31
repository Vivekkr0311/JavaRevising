package com.Vivek.LeetCode.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.ArraysQuestionOnRecursion.RotatedBinarySearch;

import java.util.Scanner;

public class SearchInRotatedSortedArray {

    static int search(int[] arr, int target, int start, int end){

        if(start > end){
            return -1;
        }

        int mid = start + (end - start)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(arr[start] <= arr[mid]){
            if(target >= arr[start] && target <= arr[mid]){
                return search(arr, target, start, mid - 1);
            }else{
                return search(arr, target, mid + 1, end);
            }
        }

        if(target >= arr[mid] && target <= arr[end]){
            return search(arr, target, mid + 1, end);
        }
        return search(arr, target, start, mid - 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insert number of elements: ");
        int numberOfElements = input.nextInt();
        int[] arr = new int[numberOfElements];

        System.out.println("Enter elements: ");
        for(int i = 0; i < numberOfElements; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Insert target to find: ");
        int target = input.nextInt();
        System.out.println("Array is rotated after: " +  search(arr, target, 0,arr.length - 1));
    }
}
