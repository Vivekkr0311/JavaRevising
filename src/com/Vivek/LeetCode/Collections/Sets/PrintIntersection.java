package com.Vivek.LeetCode.Collections.Sets;

import java.util.HashSet;
import java.util.Scanner;

public class PrintIntersection {

    static void printIntersection(int[] set1, int[] set2){
        HashSet<Integer> hashSet = new HashSet<>();
        for(int item : set2)
            hashSet.add(item);

        for(int item :  set1)
            if(hashSet.contains(item)){
                System.out.print(item + " ");
            }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("INFORMATION ABOUT SET ONE: ");
        System.out.println("Enter how many elements? ");
        int n = input.nextInt();
        System.out.println("Enter each elements: ");
        int[] setOne = new int[n];
        for(int i = 0; i < n; i++){
            setOne[i] = input.nextInt();
        }

        System.out.println("INFORMATION ABOUT SET TWO: ");
        System.out.println("Enter how many elements? ");
        n = input.nextInt();
        System.out.println("Enter each elements: ");
        int[] setTwo = new int[n];
        for(int i = 0; i < n; i++){
            setTwo[i] = input.nextInt();
        }

        printIntersection(setOne, setTwo);
    }
}
