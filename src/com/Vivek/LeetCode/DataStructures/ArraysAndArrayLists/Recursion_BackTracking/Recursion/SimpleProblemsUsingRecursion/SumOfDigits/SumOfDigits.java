package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.SumOfDigits;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        System.out.println("Sum of digits of " + number + " is " + sumOfDigits(number));
    }

    static int sumOfDigits(int n){
        if(n%10 == n){
            return n;
        }

        return (n%10) + sumOfDigits(n/10);
    }
}
