package com.Vivek.Collections.Sets;

import java.util.HashSet;
import java.util.Scanner;

public class PrintRepeatingItem {

    static void printRepeatingItem(int[] arr){
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(!hashSet.contains(arr[i])){
                hashSet.add(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
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

        printRepeatingItem(inputArr);
    }
}
