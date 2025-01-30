package com.Vivek.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class MinimumCommonValue {
    private static int search(int target, int[] nums2){
        int start = 0;
        int end = nums2.length - 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(nums2[mid] == target){
                return mid;
            }else if(nums2[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int getCommon(int[] nums1, int[] nums2){
        for(int i = 0; i < nums1.length; i++){
            int idx = search(nums1[i], nums2);

            if(idx != -1){
                return nums2[idx];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements in first array: ");
        int n = scanner.nextInt();
        int[] nums1 = new int[n];

        System.out.println("Enter each element for nums1: ");
        for(int i = 0; i < n; i++){
            nums1[i] = scanner.nextInt();
        }

        System.out.println("How many elements in second array: ");
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];

        System.out.println("Enter each element for nums2: ");
        for(int i = 0; i < n2; i++){
            nums2[i] = scanner.nextInt();
        }

        System.out.println("Lowest common number: " + getCommon(nums1, nums2));
    }
}
