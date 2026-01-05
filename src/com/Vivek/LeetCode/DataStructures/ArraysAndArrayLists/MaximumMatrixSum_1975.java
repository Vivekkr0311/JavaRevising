package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class MaximumMatrixSum_1975 {
    private static long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        long sum = 0;
        int countNegatives = 0;
        int smallestAbsoluteValue = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);

                if (matrix[i][j] < 0) {
                    countNegatives++;
                }

                smallestAbsoluteValue = Math.min(smallestAbsoluteValue, Math.abs(matrix[i][j]));
            }
        }

        if (countNegatives % 2 == 0) {
            return sum;
        }

        return sum - 2L * smallestAbsoluteValue;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Maximum Matrix Sum: " + maxMatrixSum(matrix));
    }
}
