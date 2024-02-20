package com.Vivek.CustomDataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Heaps {

    static ArrayList<Integer> heapify(ArrayList<Integer> arr, int n){
        for (int i = n; i > 0;) {
            int parentIdx;
            if((i & 1) == 1){
                parentIdx = (int)Math.floor(i / 2);
            }else {
                parentIdx = (int)Math.floor(i/2) - 1;
            }

            if (arr.get(i) > arr.get(parentIdx)) {
                int temp = arr.get(i);
                arr.set(i, arr.get(parentIdx));
                arr.set(parentIdx, temp);
            }
            i--;
        }
        return arr;
    }

    static ArrayList<Integer> insertElement(ArrayList<Integer> arr, int num){
        arr.add(num);
        arr = heapify(arr, arr.size() - 1);
        return arr;
    }
    public static void main(String[] args) {
//        How many elements?
//                5
//        Enter each elements:
//        7 8 2 4 100
//        [100, 8, 2, 4, 7]
//        [8, 7, 2, 4, 100]
//        [4, 7, 2, 8, 100]
//        [7, 2, 4, 8, 100]
//        [2, 7, 4, 8, 100]
        Scanner input = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = input.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter each elements: ");
        for(int i = 0; i < n; i++){
            arr = insertElement(arr, input.nextInt());
        }
        System.out.println(arr);
    }
}
