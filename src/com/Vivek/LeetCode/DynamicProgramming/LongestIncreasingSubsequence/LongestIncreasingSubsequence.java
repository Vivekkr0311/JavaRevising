package com.Vivek.LeetCode.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    // This is brute force method.
    // It take O(2 ^ n) time.

    static void allSubsequence(int[] arr, int idx, List<Integer> curr, List<List<Integer>> subs){
        if(idx == arr.length){
            subs.add(new ArrayList<>(curr));
            return;
        }

        curr.add(arr[idx]);
        allSubsequence(arr, idx + 1, curr, subs);

        curr.remove(curr.size() - 1);
        allSubsequence(arr, idx + 1, curr, subs);
    }

    static List<List<Integer>> allSubsequence(int[] arr){
        List<List<Integer>> subs = new ArrayList<>();
        allSubsequence(arr, 0, new ArrayList<>(), subs);
        return subs;
    }

    static boolean isIncreasing(List<Integer> list){
        for(int i = 1; i < list.size(); i++){
            if(list.get(i - 1) < list.get(i)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    static int longestIncreasingSubsequence(int[] arr){
        int res = 0;
        List<List<Integer>> subs = allSubsequence(arr);
        System.out.println("All subsequence possible are below: ");
        for(List<Integer> list : subs){
            System.out.println(list);
        }
        for(List<Integer> list : subs){
            if(isIncreasing(list) && list.size() > res){
                res = list.size();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = input.nextInt();
        int[] arr = new int[n];
//        Enter the number of elements:
//        7
//        3 4 2 8 10 5 1
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Longest Increasing Subsequence is: " + longestIncreasingSubsequence(arr));
    }
}
