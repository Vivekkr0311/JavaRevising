package com.Vivek.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.ArraysQuestionOnRecursion.RotatedBinarySearch;

import java.util.Scanner;

public class RotatedBinarySearch {

    static int rotatedBinarySearch(int[] arr, int start, int end){

        int mid = start + (end - start)/2;

        if(arr[mid - 1] > arr[mid]){
            return mid - 1;
        }

        if(arr[mid] >= arr[mid - 1]){
            return rotatedBinarySearch(arr, mid + 1, end);
        }else{
            return rotatedBinarySearch(arr, start, mid - 1);
        }
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

        System.out.println("Array is rotated after: " +  rotatedBinarySearch(arr, 0, arr.length - 1));
    }
}
