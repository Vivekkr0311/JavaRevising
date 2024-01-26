package com.Vivek.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class LargestPermutations_05 {

    static int findMax(int[] arr, int start, int end){
        int maxIdx = start;

        for(int i = start; i <= end; i++){
            if(arr[i] > arr[maxIdx]){
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    static void largestPermutation(int[] arr, int swap){
        int start = 0;
        int end = arr.length - 1;
        while(swap != 0){
            int idxMax = findMax(arr, start, end);
            int max = arr[idxMax];
            arr[idxMax] = arr[start];
            arr[start] = max;
            swap--;
            start++;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        //Test case: 1 3 2, swap: 1
        //           1 2 3 4, swap: 1
        //           3 2 4 1 5, swap: 3
        Scanner input = new Scanner(System.in);
        System.out.println("Number of elements?");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Enter number swap: ");
        int swp = input.nextInt();
        largestPermutation(arr, swp);
    }
}
