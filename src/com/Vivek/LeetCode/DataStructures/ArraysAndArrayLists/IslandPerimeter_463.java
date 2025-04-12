package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class IslandPerimeter_463 {
    
    private static int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int result = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int currPerimeter = 0;

                if (grid[row][col] == 1) {
                    // up check
                    if (row == 0 || row > 0 && grid[row - 1][col] == 0) {
                        currPerimeter++;
                    }

                    // left check
                    if (col == 0 || col > 0 && grid[row][col - 1] == 0) {
                        currPerimeter++;
                    }

                    // right check
                    if (col == grid[row].length - 1 || col < grid[row].length - 1 && grid[row][col + 1] == 0) {
                        currPerimeter++;
                    }

                    // down check
                    if (row == grid.length - 1 || row < grid.length - 1 && grid[row + 1][col] == 0) {
                        currPerimeter++;
                    }
                }
                result += currPerimeter;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] grid = new int[rows][cols];
        System.out.println("Enter the grid (0 for water, 1 for land): ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Island Perimeter: " + islandPerimeter(grid));
    }
}