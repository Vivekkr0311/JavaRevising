package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimumOperationsToMakeAUni_ValueGrid_2033 {
    private static int minOperation(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array.add(grid[i][j]);
            }
        }

        int L = array.size();
        Collections.sort(array);
        int target = array.get(L / 2);

        int result = 0;
        for (int i : array) {
            if (i % x != target % x) {
                return -1;
            }
            result += Math.abs(target - i) / x;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter m: ");
        int m = scanner.nextInt();

        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        int[][] grid = new int[m][n];
        System.out.println("Enter (x, y): ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter x: ");
        int x = scanner.nextInt();

        System.out.println("Minimum number of operations to make all equal: " + minOperation(grid, x));
    }
}