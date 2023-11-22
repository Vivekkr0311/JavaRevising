package com.Vivek.Recursion.SimpleProblemsUsingRecursion.ReverseNumber;

import java.util.Scanner;

public class ReverseNumber {

    static int sum = 0;
    static void reverseNumber(int n){
        if(n == 0){
            return;
        }

        int rem = n % 10;

        sum = sum * 10 + rem;
        reverseNumber(n/10);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        reverseNumber(number);
        System.out.println("Reverse of " + number + " is " + sum);
    }
}
