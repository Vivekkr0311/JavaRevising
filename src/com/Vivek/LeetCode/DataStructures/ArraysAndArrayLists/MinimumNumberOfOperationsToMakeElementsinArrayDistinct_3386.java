package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class MinimumNumberOfOperationsToMakeElementsinArrayDistinct_3386 {
    private static int minOperations(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[101];
        for(int i = n - 1 ; i >= 0 ; i--){
            if(seen[nums[i]])
                return i / 3 + 1;
            else seen[nums[i]] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Minimum number of operations to make elements distinct: " + minOperations(nums));
    }
}