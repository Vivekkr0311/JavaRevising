package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.TwoPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangleII_119 {
    private static List<Integer> getRow(int numRows) {
        List<Integer> row = new ArrayList<>();
        if (numRows == 0) {
            row.add(1);
            return row;
        }

        if (numRows == 1) {
            row.add(1);
            row.add(1);
            return row;
        }

        long initialValue = 1;
        for (int i = 0; i <= numRows; i++) {
            row.add((int) initialValue);
            initialValue = initialValue * (numRows - i) / (i + 1);
        }
        return row;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row number: ");
        int n = scanner.nextInt();

        System.out.println("Row is: " + getRow(n));
    }
}
