package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class FindTheDistanceValueBetweenTwoArrays {
    private static int helper(int[] arr2, int target, int d){
        int startIdx = 0;
        int lastIdx = arr2.length - 1;

        while(startIdx <= lastIdx){
            int mid = startIdx + ((lastIdx - startIdx) >> 1);

            int d2 = Math.abs(arr2[mid] - target);
            if(d == d2){
                return mid;
            }else if(arr2[mid] > d - target){
                lastIdx =  mid - 1;
            }else{
                startIdx = mid + 1;
            }
        }
        return startIdx;
    }

    private static int findTheDistanceValueBetweenTwoArrays(int[] arr1, int[] arr2, int d){
        int ans = 0;
        for (int i = 0; i < arr1.length; i++) {
            int index = helper(arr2, arr1[i], d);
            // Check if there's any element in arr2 that is within the distance d
            if (index > 0 && Math.abs(arr2[index - 1] - arr1[i]) <= d) {
                continue; // Found an element within the distance
            }
            if (index < arr2.length && Math.abs(arr2[index] - arr1[i]) <= d) {
                continue; // Found an element within the distance
            }
            ans++; // Increment if no elements in arr2 are within distance d
        }
        return ans; // Return the count of valid elements in arr1
    }

    private static int findTheDistanceValueBetweenTwoArraysBruteForce(int[] arr1, int[] arr2, int d){
        int count = 0;
        for(int i = 0; i < arr1.length; i++){
            boolean found = false;
            for(int j = 0; j < arr2.length; j++){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    found = true;
                    break;
                }
            }

            if (found){
                count++;
            }
        }
        return arr1.length - count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of elements for array1: ");
        int n = scanner.nextInt();
        System.out.println("Enter elements of array1: ");
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++){
            arr1[i] = scanner.nextInt();
        }

        System.out.println("Number of elements for array2: ");
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        System.out.println("Enter elements for array2: ");
        for(int i = 0; i < m; i++){
            arr2[i] = scanner.nextInt();
        }

        System.out.println("Enter d: ");
        int d = scanner.nextInt();

        System.out.println("Number of elements for |arr[i] - arr[j]| <= d (" + d + "): " +  findTheDistanceValueBetweenTwoArrays(arr1, arr2, d));
//        System.out.println("Number of elements for |arr[i] - arr[j]| <= d (" + d + "): " +  findTheDistanceValueBetweenTwoArraysBruteForce(arr1, arr2, d));
    }
}
