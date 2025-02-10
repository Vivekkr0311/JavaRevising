package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

// https://leetcode.com/problems/grumpy-bookstore-owner/description/?envType=problem-list-v2&envId=sliding-window
public class GrumpyBookstoreOwener_1052 {
    private static int prefixSum(int[] customers, int minutes) {
        int[] prefix = new int[customers.length];
        int windowSum = 0;
        int maxPrefixWasAt = -1;
        for (int i = 0; i < minutes; i++) {
            windowSum = windowSum + customers[i];
            prefix[i] = windowSum;
        }

        for (int i = minutes; i < customers.length; i++) {
            windowSum = windowSum + customers[i] - customers[i - minutes];
            if (windowSum > prefix[i - 1]) {
                maxPrefixWasAt = i;
            }
            prefix[i] = Math.max(prefix[i - 1], windowSum);
        }

        return maxPrefixWasAt;
    }

    private static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        if (customers.length == 1) {
            if (grumpy[0] == 0 || (grumpy[0] == 1 && minutes >= customers.length)) {
                return customers[0];
            } else {
                return 0;
            }
        }
        int maxCustomersWasAt = prefixSum(customers, minutes);
        int numberOfCustomerSatisfied = 0;
        int startOfMaxTraffic = maxCustomersWasAt - minutes + 1;
        for (int i = 0; i < customers.length; i++) {
            int isGrumpy = grumpy[i];

            if ((i >= startOfMaxTraffic && i <= maxCustomersWasAt)|| isGrumpy == 0) {
                numberOfCustomerSatisfied += customers[i];
            }
        }

        return numberOfCustomerSatisfied;
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
