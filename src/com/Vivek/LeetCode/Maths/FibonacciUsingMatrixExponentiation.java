package com.Vivek.LeetCode.Maths;

import java.util.Scanner;

public class FibonacciUsingMatrixExponentiation {
    private static int[][] matrixMultiplication(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int rowB = B.length;
        int colB = B[0].length;

        if (colA != rowB) {
            throw new IllegalArgumentException("Incompatible matrix sizes for multiplication");
        }

        int[][] C = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    private static int[][] matrixExponentiation(int[][] base, int exponent) {
        int[][] result = new int[2][2];
        if (exponent == 0) {
            // return identity matrix
            int[][] I = {
                    {1, 0},
                    {0, 1}
            };
            return I;
        }

        int[][] half = matrixExponentiation(base, exponent >> 1);
        result = matrixMultiplication(half, half);
        if ((exponent & 1) == 1) {
            result = matrixMultiplication(result, base);
        }

        return result;
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[][] T = {
                {1, 1},
                {1, 0}
        };
        int[][] I = {
                {1},
                {0}
        };


        int[][] T_n_1 = matrixExponentiation(T, n - 1);
        int[][] result = matrixMultiplication(T_n_1, I);
        return result[0][0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println(n + "th Fibonacci: " + fibonacci(n));
    }
}