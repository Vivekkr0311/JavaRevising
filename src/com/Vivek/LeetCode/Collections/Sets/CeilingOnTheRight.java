package com.Vivek.LeetCode.Collections.Sets;

import java.util.Scanner;
import java.util.TreeSet;

public class CeilingOnTheRight {

    static void ceilingOnTheRight(int[] arr){
        TreeSet<Integer> treeSet = new TreeSet<>();
        int[] res = new int[arr.length];

        for(int i = arr.length -1; i >= 0; i--){
            Integer ceil = treeSet.ceiling(arr[i]);
            if(ceil == null){
                res[i] = -1;
            } else {
                res[i] = ceil;
            }
            treeSet.add(arr[i]);
        }

        for(int item : res)
            System.out.print(item +  " ");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many elements? ");
        int n = input.nextInt();
        System.out.println("Enter each elements: ");
        int[] inputArr = new int[n];
        for(int i = 0; i < n; i++){
            inputArr[i] = input.nextInt();
        }

        ceilingOnTheRight(inputArr);
    }
}
