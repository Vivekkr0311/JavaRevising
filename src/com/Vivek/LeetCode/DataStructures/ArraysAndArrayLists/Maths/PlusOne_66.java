package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Maths;

import java.util.Arrays;
import java.util.Scanner;

public class PlusOne_66 {
    private static int[] plusOneTrick(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    private static int[] plusOne(int[] digits) {
        int right = digits.length - 1;
        int carry = 0;
        int sum = 0;

        while (right >= 0) {
            if (right == digits.length - 1) {
                sum = digits[right] + 1;
            } else {
                sum = carry + digits[right];
            }

            carry = sum / 10;
            int d = sum % 10;
            digits[right] = d;
            right--;
        }

        if (carry != 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }

        return digits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] digits = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            digits[i] = scanner.nextInt();
        }

        System.out.println("Number after adding 1: " + Arrays.toString(plusOne(digits)));
        System.out.println("Number after adding 1: " + Arrays.toString(plusOneTrick(digits)));
    }
}