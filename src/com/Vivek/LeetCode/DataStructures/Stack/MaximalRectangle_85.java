package com.Vivek.LeetCode.DataStructures.Stack;

import java.util.Scanner;
import java.util.Stack;

public class MaximalRectangle_85 {
    private static int MAH(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int area = 0;
        while (i < n) {
            if (st.isEmpty() || heights[i] >= heights[st.peek()]) {
                st.push(i++);
            } else {
                int index = st.pop();

                if (st.isEmpty()) {
                    area = heights[index] * i;
                } else {
                    area = heights[index] * (i - st.peek() - 1);
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        while (!st.isEmpty()) {
            int index = st.pop();

            if (st.isEmpty()) {
                area = heights[index] * i;
            } else {
                area = heights[index] * (i - st.peek() - 1);
            }

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int maxArea = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        for (int col = 0; col < n; col++) {
            heights[col] = matrix[0][col] == '0' ? 0 : 1;
        }

        maxArea = MAH(heights, n);

        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '0') {
                    heights[col] = 0;
                } else {
                    heights[col] += 1;
                }
            }

            maxArea = Math.max(maxArea, MAH(heights, n));
        }

        return maxArea;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row: ");
        int row = scanner.nextInt();

        System.out.println("Enter the column: ");
        int column = scanner.nextInt();

        char[][] matrix = new char[row][column];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }

        System.out.println("Maximum area of 1's: " + maximalRectangle(matrix));
    }
}
