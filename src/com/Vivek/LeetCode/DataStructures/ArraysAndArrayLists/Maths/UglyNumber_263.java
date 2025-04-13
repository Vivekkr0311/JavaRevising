package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Maths;

import java.util.Scanner;

public class UglyNumber_263 {
    private static boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }

        return n == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println("Is Ugly number: " + isUgly(n));
    }
}
