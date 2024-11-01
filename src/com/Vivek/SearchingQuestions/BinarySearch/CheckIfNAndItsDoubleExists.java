package com.Vivek.SearchingQuestions.BinarySearch;

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
    }
}
