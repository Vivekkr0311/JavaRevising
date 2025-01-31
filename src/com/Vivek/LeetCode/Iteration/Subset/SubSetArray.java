package com.Vivek.LeetCode.Iteration.Subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubSetArray {

    static List<List<Integer>> subset(int []arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();

            for(int i = 0; i < n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of the array: ");
        int n = input.nextInt();
        int []arr = new int[n];

        System.out.println("Enter elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        List<List<Integer>> ans = subset(arr);

        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }
}
