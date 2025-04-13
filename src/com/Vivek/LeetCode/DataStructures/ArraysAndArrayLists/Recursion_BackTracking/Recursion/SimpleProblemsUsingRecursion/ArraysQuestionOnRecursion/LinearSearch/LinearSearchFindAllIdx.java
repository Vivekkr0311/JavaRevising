package com.Vivek.LeetCode.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.ArraysQuestionOnRecursion.LinearSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearchFindAllIdx {

    static ArrayList<Integer> findAllIdx(long[] arr, ArrayList<Integer> ans, long target, int idx){
        if(idx > arr.length - 1){
            return ans;
        }

        if(arr[idx] == target){
            ans.add(idx);
        }
        return findAllIdx(arr, ans, target, idx  +1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insert number of elements: ");
        int numberOfElements = input.nextInt();
        long[] arr = new long[numberOfElements];

        System.out.println("Enter elements: ");
        for(int i = 0; i < numberOfElements; i++){
            arr[i] = input.nextLong();
        }

        System.out.println("Give target: ");
        long target = input.nextLong();

        System.out.println("All idx of target: " +  findAllIdx(arr, new ArrayList<>(), target, 0));
    }
}
