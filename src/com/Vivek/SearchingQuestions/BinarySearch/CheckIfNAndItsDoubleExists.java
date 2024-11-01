package com.Vivek.SearchingQuestions.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class CheckIfNAndItsDoubleExists {

    private static boolean checkIfNAndItsDoubleExistsBruteForce(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i != j && arr[i] == arr[j] * 2){
                    return true;
                }
            }
        }
        return false;
    }

    private static int search(int[] arr, int target){
        int startIdx = 0;
        int endIdx = arr.length - 1;

        while(startIdx <= endIdx){
            int mid = startIdx + ((endIdx - startIdx) >> 1);

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                endIdx = mid - 1;
            }else{
                startIdx = mid + 1;
            }
        }
        return -1;
    }

    private static boolean checkIfNAndItsDoubleExists(int[] arr){
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            int foundIdx = search(arr, arr[i] * 2);
            if(foundIdx != -1 && foundIdx != i){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter each elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("If N and its double exists: " + checkIfNAndItsDoubleExistsBruteForce(arr));
        System.out.println("If N and its double exists: " + checkIfNAndItsDoubleExists(arr));
    }
}
