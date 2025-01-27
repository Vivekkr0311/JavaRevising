package com.Vivek.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.ArraysQuestionOnRecursion.LinearSearch;

import java.util.Scanner;

public class LinearSearch {
    static boolean linearSearch(long[] arr, long target, int idx){
        if(idx > arr.length - 1){
            return false;
        }

        return arr[idx] == target || linearSearch(arr, target, idx + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert number of elements for your array?");
        int numberOfElements = input.nextInt();

        long[] arr = new long[numberOfElements];

        System.out.println("Insert your elements??");

        for(int i = 0; i < numberOfElements; i++){
            arr[i] = input.nextLong();
        }

        System.out.println("Which element to find??");
        long target = input.nextLong();

        System.out.println("Is target present in the array: " +  linearSearch(arr, target, 0));
    }
}
