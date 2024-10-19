package com.Vivek.SearchingQuestions.LinearSearch;

import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {

    private static int missingNumber(int[] arr){
        int n = arr.length;
        int sum = n * (n + 1) / 2;
        int sum2 = 0;

        for(int i = 0; i < n; i++){
            sum2 += arr[i];
        }

        return sum - sum2;
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
