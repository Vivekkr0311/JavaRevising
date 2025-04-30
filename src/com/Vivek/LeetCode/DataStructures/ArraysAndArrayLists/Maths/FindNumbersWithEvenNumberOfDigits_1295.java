package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Maths;

import java.util.Scanner;

public class FindNumbersWithEvenNumberOfDigits_1295 {
    private static int countDigits(int n) {
        int cnt = 0;
        while (n > 0) {
            n = n / 10;
            cnt++;
        }

        return cnt;
    }

    private static int findNumbers(int[] nums) {
        int cnt = 0;
        for (int i : nums) {
            if ((countDigits(i) & 1) == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    // using constraints
    private static int findNumbers_(int[] nums) {
        int cnt = 0;
        for (int i : nums) {
            boolean twoDigits = (i >= 10) && (i <= 99);
            boolean fourDigits = (i >= 1000) && (i <= 9999);
            boolean sixDigits = (i >= 100000) && (i <= 999999);
            if (twoDigits || fourDigits || sixDigits) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each number: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Number of numbers which have even number of digits: " + findNumbers(nums));
        System.out.println("Number of numbers which have even number of digits: " + findNumbers_(nums));
    }
}
