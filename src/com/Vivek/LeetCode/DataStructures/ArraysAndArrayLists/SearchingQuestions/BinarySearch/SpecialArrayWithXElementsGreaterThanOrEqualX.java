package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    private static int helper(int[] nums, int target){
        int start = 0;
        int end = nums.length;

        while(start < end){
            int mid = start + ((end - start) >> 1);

            if(nums[mid] >= target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }

    private static int specialArray(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length; i++){
            int position = helper(nums, i);

            int numberOfElementsAfterPositon = nums.length - position;
            if(i == numberOfElementsAfterPositon){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Number of element: " + specialArray(arr));
    }
}
