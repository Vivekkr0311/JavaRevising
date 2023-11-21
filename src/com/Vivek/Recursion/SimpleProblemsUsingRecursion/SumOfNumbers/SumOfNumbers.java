package com.Vivek.Recursion.SimpleProblemsUsingRecursion.SumOfNumbers;

import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        System.out.println("Sum: " + sum(number));
        System.out.println("Sum: " + sumTwo(number));
    }

    static int sum(int n){
        if(n == 1){
            return n;
        }

        return n + sum(n - 1);
    }

    //O(1) solution, using formula.
    static int sumTwo(int n){
        return n*(n + 1)/2;
    }
}
