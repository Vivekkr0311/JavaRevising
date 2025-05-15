package com.Vivek.LeetCode.Maths;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixExponentiation {
    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[][] createMatrix() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of row: ");
        int row = scanner.nextInt();

        System.out.println("Enter number of column: ");
        int col = scanner.nextInt();

        int[][] matrix = new int[row][col];
        System.out.println("Enter elements: ");
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }

        printMatrix(matrix);
        return matrix;
    }

    private static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;

        int n1 = B.length;
        int m1 = B[0].length;


        if (n != n1) {
            System.out.println("Cannot be multiplied");
            return new int[0][0];
        }

        int[][] result = new int[m][m1];

        for (int r = 0; r < m; r++) {
            int[] currRowA = A[r];

            for (int c = 0; c < m1; c++) {
                int currE = 0;
                for (int i = 0; i < currRowA.length; i++) {
                    currE = currE + (currRowA[i] * B[i][c]);
                }
                result[r][c] = currE;
            }
        }

        return result;
    }


    private static int[][] matrixExponentiation(int[][] A, int n) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            result[i][i] = 1;
        }

        while (n > 0) {
            if ((n & 1) == 1) {
                result = multiply(result, A);
            }
            A = multiply(A, A);
            n = n >> 1;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] A = createMatrix();
        System.out.println("Enter n (A^n): ");
        int n = scanner.nextInt();

        int[][] result = matrixExponentiation(A, n);
        printMatrix(result);
    }
}
