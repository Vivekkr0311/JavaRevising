package com.Vivek.DynamicProgramming.Fibonacci;

import java.util.Scanner;

public class Recursion {

    static int fibonacci(int n){
        if(n == 1 || n ==0){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n to find nth fibonacci number: ");
        int n = input.nextInt();
        System.out.println("nth fibonacci number is: " + fibonacci(n));
    }
}
