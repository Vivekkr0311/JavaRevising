package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.*;

public class IntersectionOfTwoArraysII {

    private static int[] intersection(int[] nums1, int[] nums2) {
        // Binary Search implementation pending
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] != nums2[j]){
                if(nums1[i] < nums2[j]){
                    i++;
                }else{
                    j++;
                }
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] ans = new int[list.size()];
        int idx = 0;
        for(int num : list){
            ans[idx++] = num;
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
