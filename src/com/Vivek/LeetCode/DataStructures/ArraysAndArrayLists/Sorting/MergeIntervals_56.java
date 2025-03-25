package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals_56 {
    private static void print(int[][] interval) {
        for (int[] arr : interval) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0]; // Start with the first interval
        merged.add(current);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Merge intervals by extending the end time
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // Move to the next interval
                current = intervals[i];
                merged.add(current);
            }
        }

        // Convert list to array
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many intervals ?");
        int n = scanner.nextInt();

        int[][] intervals = new int[n][2];
        System.out.println("Enter each interval: (x, y): ");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();

        }

        System.out.println("Intervals after merge: ");
        print(merge(intervals));
    }
}
