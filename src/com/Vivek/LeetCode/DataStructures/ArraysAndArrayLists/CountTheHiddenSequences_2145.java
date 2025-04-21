package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class CountTheHiddenSequences_2145 {
    private static boolean helper(int[] differences, int lower, int upper, int i) {
        int[] temp = new int[differences.length + 1];

        temp[0] = i;
        for (int idx = 1; idx < temp.length; idx++) {
            int x = differences[idx - 1] + temp[idx - 1];
            if (lower <= x && x <= upper) {
                temp[idx] = x;
            } else {
                return false;
            }
        }

        return true;
    }

    private static int countValidSequences(int[] differences, int lower, int upper) {
        int count = 0;
        for (int i = upper; i >= lower; i--) {
            boolean foundSolution = helper(differences, lower, upper, i);
            if (foundSolution) {
                count++;
            }
        }
        return count;
    }

    private static int countValidSequences_(int[] differences, int lower, int upper) {
        int curr = 0;
        int minVal = 0;
        int maxVal = 0;

        for (int d : differences) {
            curr += d;
            minVal = Math.min(minVal, curr);
            maxVal = Math.max(maxVal, curr);

            if ((upper - maxVal) - (lower - minVal) + 1 <= 0) {
                return 0;
            }
        }

        return (upper - maxVal) - (lower - minVal) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of differences in the array:");
        int n = scanner.nextInt();

        int[] differences = new int[n];
        System.out.println("Enter the differences:");
        for (int i = 0; i < n; i++) {
            differences[i] = scanner.nextInt();
        }

        System.out.println("Enter the lower bound (lower):");
        int lower = scanner.nextInt();

        System.out.println("Enter the upper bound (upper):");
        int upper = scanner.nextInt();

        System.out.println("Number of valid sequences: " + countValidSequences(differences, lower, upper));
        System.out.println("Number of valid sequences: " + countValidSequences_(differences, lower, upper));
    }
}