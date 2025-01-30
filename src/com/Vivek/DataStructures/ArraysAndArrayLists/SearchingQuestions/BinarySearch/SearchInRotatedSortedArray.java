package com.Vivek.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class SearchInRotatedSortedArray {
    private static int findPivot(int[] nums){
        int pivot =  -1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] > nums[i]){
                pivot = i - 1;
            }
        }
        return pivot;
    }

    private static int findPivotEfficiently(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }

            if(mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }

            if(nums[start] < nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    private static int search(int[] nums, int target){
//        int pivot = findPivot(nums);
        int pivot = findPivotEfficiently(nums);
        if(pivot == -1){
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        int findLeftOfPivot = binarySearch(nums, 0, pivot, target);
        int findRightOfPivot = -1;
        if(findLeftOfPivot == -1){
            findRightOfPivot = binarySearch(nums, pivot + 1, nums.length - 1, target);
        }

        int ans = findLeftOfPivot != -1 ? findLeftOfPivot : findRightOfPivot;
        return ans;
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

        System.out.println("Enter the target element: ");
        int target = scanner.nextInt();

        System.out.println(target + " is found in the array: " + search(arr, target));
    }
}
