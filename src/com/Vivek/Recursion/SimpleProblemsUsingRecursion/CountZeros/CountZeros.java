package com.Vivek.Recursion.SimpleProblemsUsingRecursion.CountZeros;

import java.util.Scanner;

public class CountZeros {

    static long count = 0;
    static void countZeros(long n){
        if(n%10 == n){
            return;
        }

        if(n == 0){
            count++;
        }

        long rem = n%10;
        if(rem == 0){
            count++;
        }

        countZeros(n/10);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();

        countZeros(number);
        System.out.println("Number of zeros in " + number + " is " + count);
    }
}
