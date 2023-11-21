package com.Vivek.Recursion.SimpleProblemsUsingRecursion.Factorial;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        System.out.println("Factorial of " + number + " is " + factorial(number));
    }

    static int factorial(int n){
        if(n <= 1){
            return n;
        }

        return n * factorial(n - 1);
    }
}
