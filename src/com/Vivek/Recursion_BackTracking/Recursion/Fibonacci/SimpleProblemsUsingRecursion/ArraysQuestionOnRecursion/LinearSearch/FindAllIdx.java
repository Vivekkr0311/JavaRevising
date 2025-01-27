package com.Vivek.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.ArraysQuestionOnRecursion.LinearSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class FindAllIdx {

    static ArrayList<Integer> findAllIdx(int[] arr, int target, int idx){
        ArrayList<Integer> list = new ArrayList<>();

        if(idx == arr.length - 1){
            return list;
        }

        if(arr[idx] == target){
            list.add(idx);
        }

        ArrayList<Integer> ans = findAllIdx(arr, target, idx  +1);
        list.addAll(ans);

        return list;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insert number of elements: ");
        int numberOfElements = input.nextInt();
        int[] arr = new int[numberOfElements];

        System.out.println("Enter elements: ");
        for(int i = 0; i < numberOfElements; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Give target: ");
        int target = input.nextInt();

        System.out.println("All idx of target: " +  findAllIdx(arr, target, 0));
    }
}
