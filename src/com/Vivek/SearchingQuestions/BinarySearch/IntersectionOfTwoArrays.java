package com.Vivek.SearchingQuestions.BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IntersectionOfTwoArrays {

    private static int search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -(start + 1);
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        int idxAns = 0;
        for(int i = 0; i < nums1.length; i++){
            int idx = search(nums2, nums1[i]);

            if(idx >= 0){
                set.add(nums1[i]);
            }
        }

        int[] ans = new int[set.size()];
        for(int num : set){
            ans[idxAns++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements? arr1: ");
        int n1 = scanner.nextInt();

        int[] arr1 = new int[n1];
        System.out.print("Insert each elements: arr1 ");
        for(int i = 0; i < n1; i++){
            arr1[i] = scanner.nextInt();
        }

        System.out.println("How many elements? arr12 ");
        int n2 = scanner.nextInt();

        int[] arr2 = new int[n2];
        System.out.print("Insert each elements: arr2 ");
        for(int i = 0; i < n2; i++){
            arr2[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }
}
