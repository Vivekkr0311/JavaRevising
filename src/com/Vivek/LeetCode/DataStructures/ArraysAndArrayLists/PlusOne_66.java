package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Arrays;
import java.util.Scanner;

public class PlusOne_66 {
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = scan.nextInt();
        int[] digits = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++){
            digits[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
