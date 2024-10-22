package com.Vivek.ArraysAndArrayLists.TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
    private static int removeDuplicates(int[] nums){
        int i = 0;
        int j = 1;

        while(j < nums.length){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter each elements: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Removed duplicates: " + removeDuplicates(nums) + " : " + Arrays.toString(nums));
    }
}
