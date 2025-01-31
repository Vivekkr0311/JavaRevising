package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayParition {

    static int arrayPartition(int[] arr){
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i + 1 < arr.length; i += 2){
            ans += arr[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Many elements? ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println(arrayPartition(arr));
    }
}
