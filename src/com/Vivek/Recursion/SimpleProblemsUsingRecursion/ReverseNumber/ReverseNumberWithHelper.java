package com.Vivek.Recursion.SimpleProblemsUsingRecursion.ReverseNumber;

import java.util.Scanner;

public class ReverseNumberWithHelper {

    static long reverseNumber(long n){
        long digits = (long)(Math.log10(n)) + 1;

        return reverseHelper(n, digits);
    }

    static long reverseHelper(long n, long digits){
        if(n%10 == n){
            return n;
        }

        long rem = n%10;
        return rem*(long)(Math.pow(10, digits -1)) + reverseHelper(n/10, digits -1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();

        System.out.println("Reverse of " + number + " is " + reverseNumber(number));
    }
}