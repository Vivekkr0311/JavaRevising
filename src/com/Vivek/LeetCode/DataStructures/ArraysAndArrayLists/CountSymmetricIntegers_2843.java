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
            if (isSymmetric(i)) {
                count++;
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
    }
}