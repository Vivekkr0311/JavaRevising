package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.CountZeros;

import java.util.Scanner;

public class CountZeros {

    static long countZeros(long n, long count){
        if(n == 0){
            return count;
        }

        long rem = n%10;
        if(rem == 0){
            return countZeros(n/10, count + 1);
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
