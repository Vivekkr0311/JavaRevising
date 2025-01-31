package com.Vivek.LeetCode.DynamicProgramming.Fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci_Memoization {

    // Memoization Approach (Top down approach)

    static int fibonacciMemoization(int[] memo, int n){
        if(memo[n] == -1){
            int res;
            if(n == 0 ||  n == 1){
                res = n;
            }else {
                res = fibonacciMemoization(memo,n - 1) +  fibonacciMemoization(memo, n - 2);
            }
            memo[n] = res;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n for finding nth fibonacci number: ");
        n = input.nextInt();
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println("nth fibonacci number is: " + fibonacciMemoization(memo, n));
    }
}
