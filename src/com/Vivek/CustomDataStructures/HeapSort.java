package com.Vivek.CustomDataStructures;

import java.util.ArrayList;
import java.util.Scanner;

public class HeapSort {

    static void swap(ArrayList<Integer> arr, int first, int second){
        int temp = arr.get(first);
        arr.set(first, arr.get(second));
        arr.set(second, temp);
    }

    static void heapsort(ArrayList<Integer> arr){
        for(int i = 1; i + 1 <= arr.size(); i++){
            int maxItemIdx = 0;
            swap(arr, maxItemIdx, arr.size() - i);
            heapify(arr, arr.size() - (i+1));
            System.out.println(arr);
        }
    }

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
            i = parentIdx;
        }
        return arr;
    }

    static ArrayList<Integer> insertElement(ArrayList<Integer> arr, int num){
        arr.add(num);
        arr = heapify(arr, arr.size() - 1);
        return arr;
    }
    public static void main(String[] args) {
        // 7 5 6 20
        Scanner input = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = input.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter each elements: ");
        for(int i = 0; i < n; i++){
            arr = insertElement(arr, input.nextInt());
        }
        System.out.println(arr);
        heapsort(arr);
        System.out.println(arr);
    }
}
