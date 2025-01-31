package com.Vivek.LeetCode.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.PrintingNumbers;

import java.util.Scanner;

public class NtoOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        printNtoOne(number);
    }

    static void printNtoOne(int n){
        if(n == 0){
            return;
        }

        System.out.println(n);
        printNtoOne(n - 1);
    }
}
