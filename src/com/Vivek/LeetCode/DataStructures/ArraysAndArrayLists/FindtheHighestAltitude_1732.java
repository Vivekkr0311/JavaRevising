package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class FindtheHighestAltitude_1732 {
    private static int largestAltitude(int[] gain){
        int prevLevel = 0;
        int ans = prevLevel;
        for(int i = 0; i < gain.length; i++){
            int gainLevel = prevLevel + gain[i];
            ans =  Math.max(ans,gainLevel);
            prevLevel = gainLevel;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Highest Altitude: " + largestAltitude(arr));
    }
}
