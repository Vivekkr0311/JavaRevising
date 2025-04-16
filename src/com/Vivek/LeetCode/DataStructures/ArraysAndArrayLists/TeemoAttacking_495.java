package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class TeemoAttacking_495 {
    private static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;

        int lastBoundary = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == 0) {
                lastBoundary = timeSeries[i] + duration;
                ans += duration;
            } else {
                if (i != 0 && timeSeries[i] <= lastBoundary) {
                    int diff = timeSeries[i] + duration - lastBoundary;
                    lastBoundary = timeSeries[i] + duration;
                    ans += diff;
                } else {
                    ans += duration;
                    lastBoundary = timeSeries[i] + duration;
                }
            }
        }

        return ans;
    }

    private static int findPoisonedDuration_(int[] timeSeries, int duration) {
        int ans = 0;

        int lastBoundary = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == 0) {
                ans += duration;
            } else if (timeSeries[i] <= lastBoundary) {
                int diff = timeSeries[i] + duration - lastBoundary;
                ans += diff;
            } else {
                ans += duration;
            }
            lastBoundary = timeSeries[i] + duration;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of seconds:");
        int seconds = scanner.nextInt();
        int[] timeSeries = new int[seconds];

        System.out.println("Enter the time series:");
        for (int i = 0; i < seconds; i++) {
            timeSeries[i] = scanner.nextInt();
        }

        System.out.println("Enter the duration of the poison effect:");
        int duration = scanner.nextInt();

        System.out.println("Total time of damage: " + findPoisonedDuration(timeSeries, duration));
        System.out.println("Total time of damage: " + findPoisonedDuration_(timeSeries, duration));
    }
}
