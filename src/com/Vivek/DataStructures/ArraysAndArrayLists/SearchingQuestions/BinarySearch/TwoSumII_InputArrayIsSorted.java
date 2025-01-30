package com.Vivek.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSumII_InputArrayIsSorted {
    private static int search(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] <  target){
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int[] twoSum(int[] nums, int target){
        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++){
            int find = target - nums[i];
            int idxFound = search(nums, find, i + 1, nums.length - 1);
            if(idxFound != -1){
                ans[0] = i + 1;
                ans[1] = idxFound + 1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements you have: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the target: ");
        int target = scanner.nextInt();
        System.out.println("Assuming array start with 1 index.");
        System.out.println("Indexes at which the elements present which makes up the target: " + target + " is " + Arrays.toString(twoSum(nums, target)));
    }
}
