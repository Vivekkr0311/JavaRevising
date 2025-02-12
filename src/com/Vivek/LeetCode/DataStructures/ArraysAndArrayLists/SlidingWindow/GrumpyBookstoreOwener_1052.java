package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

// https://leetcode.com/problems/grumpy-bookstore-owner/description/?envType=problem-list-v2&envId=sliding-window
public class GrumpyBookstoreOwener_1052 {
    private static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int numberOfUnsatisfiedCustomer = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                numberOfUnsatisfiedCustomer += customers[i];
            }
        }

        int i = 0;
        int j = i + minutes;
        int window_count = numberOfUnsatisfiedCustomer;
        while (j < n) {
            if (grumpy[j] == 1) {
                window_count += customers[j];
            }

            if (grumpy[i] == 1) {
                window_count -= customers[i];
            }

            numberOfUnsatisfiedCustomer = Math.max(window_count, numberOfUnsatisfiedCustomer);
            i++;
            j++;
        }

        int remainingCustomer = 0;
        for (int p = 0; p < customers.length; p++) {
            if (grumpy[p] == 0) {
                remainingCustomer += customers[p];
            }
        }
        return numberOfUnsatisfiedCustomer + remainingCustomer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minutes: ");
        int n = scanner.nextInt();

        System.out.println("Enter number of customer at each minute: ");
        int[] customers = new int[n];
        for (int i = 0; i < n; i++) {
            customers[i] = scanner.nextInt();
        }

        System.out.println("Enter when the shopkeeper is grumpy: ");
        int[] grumpy = new int[n];
        for (int i = 0; i < n; i++) {
            grumpy[i] = scanner.nextInt();
        }

        System.out.println("Enter the time for which the shopkeeper can remain not grumpy: ");
        int minutes = scanner.nextInt();

        System.out.println("Maximum number of customer can be satisfied: " + maxSatisfied(customers, grumpy, minutes));
    }
}
