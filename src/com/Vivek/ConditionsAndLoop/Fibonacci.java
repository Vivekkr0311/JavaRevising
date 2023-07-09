package com.Vivek.ConditionsAndLoop;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("[+] nth fibonacci number is: " + nthFibonacci(n));
    }

    static int nthFibonacci(int n){
        int a = 0;
        int b = 1;
        int c = a + b;

        System.out.print(a + " " + b + " " + c + " ");
        for(int i = 3; i < n; i++){
            a = b;
            b = c;
            c = a + b;
            System.out.print(c + " ");
        }
        System.out.println();
        return c;
    }
}
