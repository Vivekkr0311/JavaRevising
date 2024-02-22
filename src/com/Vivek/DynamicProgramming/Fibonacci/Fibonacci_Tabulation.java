package com.Vivek.DynamicProgramming.Fibonacci;

import java.util.Scanner;

public class Fibonacci_Tabulation {

    // Tabulation: Bottom up approach
    static int fibonacciTabulation(int n){
        int[] table =  new int[n + 1];
        table[0] = 0; table[1] = 1;

        for(int i = 2; i <= n; i++){
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n for finding nth fibonacci number: ");
        int n = input.nextInt();

        System.out.println("nth fibonacci number is: " + fibonacciTabulation(n));
    }
}
