package com.Vivek.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class SumOfSubArray {

    private static int sumOfSubArray(int[] arr, int subArraySize){
        if(arr.length < subArraySize){
            return -1;
        }

        int max = 0;
        for(int i = 0; i <= arr.length - subArraySize; i++){
            int sum = 0;
            for(int j = i; j < i + subArraySize; j++){
                sum += arr[j];
            }

            if(sum > max){
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        System.out.println("Enter each element: ");
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter sub array size: ");
        int r = scanner.nextInt();

        System.out.println("Max of sum of all sub array is: " + sumOfSubArray(arr, r));
    }
}
