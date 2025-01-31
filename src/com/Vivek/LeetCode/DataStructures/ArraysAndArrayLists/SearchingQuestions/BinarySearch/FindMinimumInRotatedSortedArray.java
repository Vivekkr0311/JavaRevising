package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {
    private static int findMin(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        int numberOfTimesRotated = -1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(mid < end && nums[mid] > nums[mid + 1]){
                numberOfTimesRotated = mid;
                break;
            }else if(mid > start && nums[mid] < nums[mid - 1]){
                numberOfTimesRotated = mid - 1;
                break;
            }

            if(nums[start] < nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return nums[numberOfTimesRotated + 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements do you have ?");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Minimum is: " + findMin(arr));
    }
}
