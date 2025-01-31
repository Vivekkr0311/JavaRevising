package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubsequenceWithLimitedSum {
    private static int search(int[] prefixSum, int target){
        int start = 0;
        int end = prefixSum.length - 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(prefixSum[mid] <= target){
                start = mid + 1;
            }else if(prefixSum[mid] > target){
                end = mid - 1;
            }
        }

        return end + 1;
    }

    private static int[] answerQueries(int[] nums, int[] queries){
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        int[] ansArray = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            ansArray[i] = search(prefixSum, queries[i]);;
        }

        return ansArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements: ");
        int n = scanner.nextInt();
        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("How many queries: ");
        int q = scanner.nextInt();
        System.out.println("Enter each query: ");
        int[] queries = new int[q];
        for(int i = 0; i < q; i++){
            queries[i] = scanner.nextInt();
        }

        System.out.println("Maximum size of the subsequence: " + Arrays.toString(answerQueries(nums, queries)));
    }
}
