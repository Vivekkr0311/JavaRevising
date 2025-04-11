package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class CountSymmetricIntegers_2843 {
    private static boolean isSymmetric(int num) {
        if (num == 0) {
            return false;
        }
        int numberOfDigits = (int) Math.log10(num) + 1;

        if ((numberOfDigits & 1) == 1) {
            return false;
        }

        int totalSumOfDigits = 0;
        int temp = num;
        while (temp > 0) {
            totalSumOfDigits += temp % 10;
            temp /= 10;
        }

        int halfDigitCount = 0;
        int halfSum = 0;
        while (halfDigitCount != numberOfDigits / 2) {
            halfSum += num % 10;
            num /= 10;
            halfDigitCount++;
        }

        return totalSumOfDigits == 2 * halfSum;
    }

    private static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (((i >= 10 && i <= 99 && i % 11 == 0) || (i >= 1000 && i <= 9999)) && isSymmetric(i)) {
                count++;
            }
        }
        return count;
    }

    // this below code work only for the input constraints
    // 1 <= low <= high <= 10^4 (1000)
    private static int countSymmetricIntegers_(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (i >= 10 && i <= 99 && i % 11 == 0) {
                count++;
            } else if (i >= 1000 && i <= 9999) {
                int first = i / 1000;
                int second = (i / 100) % 10;
                int third = (i / 10) % 10;
                int fourth = i % 10;

                if (first + second == third + fourth) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of low: ");
        int low = scanner.nextInt();

        System.out.println("Enter the value of high: ");
        int high = scanner.nextInt();

        System.out.println("Count of symmetric integers between " + low + " and " + high + " is: " + countSymmetricIntegers(low, high));
        System.out.println("Count of symmetric integers between " + low + " and " + high + " is: " + countSymmetricIntegers_(low, high));
    }
}