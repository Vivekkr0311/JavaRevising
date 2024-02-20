package com.Vivek.CustomDataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Heaps {

    static ArrayList<Integer> heapify(ArrayList<Integer> arr, int n){
        for(int i = n; i >  0; i--){
            if(arr.get(i) > arr.get((i - 1)/2)){
                int temp = arr.get(i);
                arr.set(i, arr.get((i- 1)/2));
                arr.set((i - 1)/2, temp);
            }else{
                break;
            }
        }
        return arr;
    }

    static ArrayList<Integer> insertElement(ArrayList<Integer> arr, int num){
        arr.add(num);
        arr = heapify(arr, arr.size() - 1);
        return arr;
    }
    public static void main(String[] args) {
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
