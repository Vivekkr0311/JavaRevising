package com.Vivek.LeetCode.Recursion_BackTracking.Recursion.Fibonacci;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("[?] Enter the which number you want to find: ");
        int nth_number = input.nextInt();

        System.out.println("nth fibonacci number is: " + fibo(nth_number));
    }

    static int fibo(int n){
        if(n < 2){
            return n;
        }

        return fibo(n - 1) + fibo( n - 2);
    }
}
