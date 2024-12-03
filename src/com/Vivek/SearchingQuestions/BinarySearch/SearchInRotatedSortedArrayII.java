package com.Vivek.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class SearchInRotatedSortedArrayII {

    private static int findPivotIterative(int[] nums){
        int pivot = -1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] > nums[i]){
                return i;
            }
        }
        return pivot;
    }

    private static int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid + 1;
            }else if(mid > start && nums[mid] < nums[mid - 1]){
                return mid;
            }

            if(nums[start] < nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    private static boolean binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }

    private static boolean search(int[] nums, int target){
//        if(nums.length == 1){
//            return nums[0] == target;
//        }
        int pivot = findPivotIterative(nums);
        if(pivot == -1){
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        return binarySearch(nums, 0, pivot - 1, target) || binarySearch(nums, pivot, nums.length - 1, target);
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

//        System.out.println("Enter the target element: ");
//        int target = scanner.nextInt();

//        System.out.println(target + " is found in the array: " + search(arr, target));
        System.out.println(findPivot(arr));
    }
}
