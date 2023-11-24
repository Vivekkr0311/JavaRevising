package com.Vivek.Recursion.SimpleProblemsUsingRecursion.CountZeros;

import java.util.Scanner;

public class CountZeros {
    
    static long countZeros(long n, long count){
        if(n%10 == n){
            return count;
        }

        if(n == 0){
            count++;
        }

        long rem = n%10;
        if(rem == 0){
            count++;
        }

        return countZeros(n/10, count);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();

        long initialCount = 0;
        System.out.println("Number of zeros in " + number + " is " + countZeros(number, initialCount));
    }
}
