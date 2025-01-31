package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class FindFirstAndLastPositionOfElementInSortedArray {
    private static int search(int[] nums, int target, boolean findRight){
        int start = 0;
        int end = nums.length - 1;

        int ans = -1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(nums[mid] == target){
                ans = mid;
                if(findRight){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int[] searchRange(int[] nums, int target){
        int firstPosition = search(nums, target, false);
        int secondPosition = search(nums, target, true);

        return new int[]{firstPosition, secondPosition};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the target: ");
        int target = scanner.nextInt();

        int[] positions = searchRange(nums, target);
        int firstPosition = positions[0];
        int secondPosition = positions[1];

        System.out.println("First position: " + firstPosition + "\n" + "Second position: " + secondPosition);
    }
}
