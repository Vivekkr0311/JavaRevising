package com.Vivek.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class FindTheDuplicateNumber {
    private static int countNumberLess(int[] nums, int target){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= target){
                count++;
            }
        }
        return count;
    }

    private static int findDuplicate(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            int count = countNumberLess(nums, mid);
            if(count > mid){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each elements: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Duplicate number is: " + findDuplicate(nums));
    }
}
