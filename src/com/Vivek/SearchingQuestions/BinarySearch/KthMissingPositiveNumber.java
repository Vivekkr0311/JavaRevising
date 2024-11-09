package com.Vivek.SearchingQuestions.BinarySearch;

import java.util.*;

public class KthMissingPositiveNumber {
    private static int findKthPositiveLogN(int[] arr, int k){
       int start = 0;
       int end = arr.length - 1;

       while(start < end){
           int mid = start + ((end -start) >> 1);

           if(arr[mid] - mid - 1 < k){
               start = mid + 1;
           }else{
               end  = mid;
           }
       }

       return arr[end] + k;
    }

    private static int findKthPositiveBigOhN(int[] arr, int k){
        int missingCount = 0;
        int lastValue = 0;

        for (int i = 0; i < arr.length; i++) {
            int currentMissing = arr[i] - (lastValue + 1);
            missingCount += currentMissing;
            
            if (missingCount >= k) {
                return arr[i] - (missingCount - k) - 1;
            }
            lastValue = arr[i];
        }

        return arr[arr.length - 1] + (k - missingCount);
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

        System.out.println("Enter kth position: ");
        int k = scanner.nextInt();

        System.out.println("Kth missing number in " + Arrays.toString(arr) + " is " + findKthPositiveBigOhN(arr, k));
        System.out.println("Kth missing number in " + Arrays.toString(arr) + " is " + findKthPositiveLogN(arr, k));
    }
}
