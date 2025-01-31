package com.Vivek.Hackerrank.ProblemSolving;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
    private static void extraLongFactorials(int n) {
        BigInteger bigInteger = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        System.out.println("Factorial of: "+ n + " is: " + bigInteger);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        extraLongFactorials(n);
    }
}
