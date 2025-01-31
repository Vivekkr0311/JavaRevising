package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class FindPeakElement {
    private static int findPeakElementTwo(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + ((end - start) >> 1);

            if(nums[mid] > nums[mid + 1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }

    private static int findPeakElement(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        if(nums.length == 1){
            return 0;
        }
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(mid == 0){
                if(nums[mid] >= nums[mid + 1]){
                    return mid;
                }else{
                    start = mid + 1;
                }
            }else if(mid == nums.length - 1){
                if(nums[mid - 1] <= nums[mid]){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }else if(mid > 0 && mid < nums.length - 1){
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                    return mid;
                }else if(nums[mid] > nums[mid - 1] && !(nums[mid] > nums[mid + 1])){
                    start = mid + 1;
                }else if(!(nums[mid] > nums[mid - 1]) && nums[mid] > nums[mid + 1]){
                    end = mid - 1;
                }else{
                    if(nums[mid - 1] > nums[mid + 1]){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = scanner.nextInt();

        System.out.println("Enter each elements: ");
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        int peak = findPeakElement(nums);
        int peak2 = findPeakElementTwo(nums);
        System.out.println("Peak of " + Arrays.toString(nums) + " is at " + peak +  " which is " + nums[peak]);
        System.out.println("Peak of " + Arrays.toString(nums) + " is at " + peak2 +  " which is " + nums[peak2]);
    }
}
