package com.Vivek.Recursion_BackTracking.Recursion.Fibonacci.SimpleProblemsUsingRecursion.PrintingNumbers;

import java.util.Scanner;

public class OneToN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        printOnetoN(number);
    }

    static void printOnetoN(int n){
        if(n == 0){
            return;
        }

        printOnetoN(n - 1);
        System.out.println(n);
    }
}
