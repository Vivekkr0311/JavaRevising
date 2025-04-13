package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class CountGoodNumbers_1922 {
    private static final long M = 1000000007;

    private static long power(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long num = power(a, b / 2);
        long result = (num * num) % M;

        if (b % 2 == 1) {
            result = (result * a) % M;
        }
        return result;
    }

    private static int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = (n / 2);

        return (int) (power(5, even) * power(4, odd) % M);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        long n = scanner.nextInt();

        System.out.println("Number of good number of digits " + n + " is: " + countGoodNumbers(n));
    }
}
