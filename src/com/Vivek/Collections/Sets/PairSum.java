package com.Vivek.Collections.Sets;

import java.util.HashSet;
import java.util.Scanner;

public class PairSum {

    static void pairSum(int[] arr, int sum){
        HashSet<Integer> hashSet = new HashSet<>();

        for(int item :  arr)
            if(hashSet.contains(sum - item)){
                System.out.print("Yes");
                return;
            }else{
                hashSet.add(item);
            }

        System.out.println("No");
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

        System.out.println("Enter sum: ");
        int sum = input.nextInt();

        pairSum(inputArr, sum);
    }
}
