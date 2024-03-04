package com.Vivek.Collections.ListInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReturnList {

    static ArrayList<Integer> smallerThanK(int[] list, int size, int k){
        // And for this question, we needed Dynamic Sized Array because we don't know
        // how many elements will be there which will be less than k.
        // We know at most it can be 'n', but we will waste space if
        // there are not much element which are less than 'k'.
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < size; i++){
            int item = list[i];
            if(item < k){
                ans.add(item);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Size of array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
         arr[i] = input.nextInt();
        }
        System.out.println("Value for k: ");
        int k = input.nextInt();

        // We are using List, using List at RHS is a good practice,
        // because later if we want to change the data structure we can do it
        // without changing much code.
        List<Integer> list = smallerThanK(arr, n, k);
        System.out.println(list);
    }
}
