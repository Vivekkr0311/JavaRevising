package com.Vivek.Recursion.SimpleProblemsUsingRecursion.PrintingNumbers;

import java.util.Scanner;

public class NtoOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        printNtoOne(number);
    }

    static void printNtoOne(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }

        System.out.println(n);
        printNtoOne(n - 1);
    }
}
