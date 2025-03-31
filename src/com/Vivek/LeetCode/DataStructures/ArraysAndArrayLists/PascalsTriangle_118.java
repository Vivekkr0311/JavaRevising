package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle_118 {
    private static void print(List<List<Integer>> triangles) {
        for (List<Integer> arr : triangles) {
            System.out.println(arr);
        }
    }

    private static List<Integer> getRows(List<Integer> previousRow, int row) {
        List<Integer> currRow = new ArrayList<>();
        if (row == 1) {
            currRow.add(1);
            return currRow;
        }

        if (row == 2) {
            currRow.add(1);
            currRow.add(1);
            return currRow;
        }

        for (int l = 0; l <= previousRow.size(); l++) {
            if (l == 0) {
                currRow.add(previousRow.get(l));
            } else if (l == previousRow.size()) {
                currRow.add(previousRow.get(l - 1));
            } else {
                currRow.add(previousRow.get(l) + previousRow.get(l - 1));
            }
        }
        return currRow;
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangles = new ArrayList<>();
        if (numRows == 0) {
            return triangles;
        }

        if (numRows == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            triangles.add(temp);
            return triangles;
        }

        List<Integer> prevRow = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> currRow = getRows(prevRow, i);
            triangles.add(currRow);
            prevRow = currRow;
        }
        return triangles;
    }

    private static List<List<Integer>> generate_(int numRows) {
        List<List<Integer>> triangles = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> currTriangle = new ArrayList<>(row + 1);
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    currTriangle.add(1);
                } else {
                    int sum = triangles.get(row - 1).get(col - 1) + triangles.get(row - 1).get(col);
                    currTriangle.add(sum);
                }
            }

            triangles.add(currTriangle);
        }
        return triangles;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = scanner.nextInt();

        System.out.println("Pascal's Triangle: ");
        List<List<Integer>> triangles = generate(n);
        List<List<Integer>> triangles_ = generate_(n);
        print(triangles);
        System.out.println("Pascal's Triangle: ");
        print(triangles_);
    }
}
