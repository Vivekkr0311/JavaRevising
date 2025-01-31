package com.Vivek.LeetCode.Iteration.Subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubSetDuplicate {

    static List<List<Integer>> subsetDuplicate(int []arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            start = 0;
            if(i > 0 && arr[i] == arr[i - 1]){
                start = end + 1;
            }

            end = outer.size() - 1;
            int n = outer.size();
            for(int j = start; j < n; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
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

        List<List<Integer>> ans = subsetDuplicate(arr);

        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }
}
