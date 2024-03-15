package com.Vivek.DynamicProgramming.EditDistance;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class EditDistanceDP {

    static int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] table = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            table[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            table[0][i] = i;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    int a = Math.min(table[i - 1][j - 1], table[i][j - 1]);
                    table[i][j] = Math.min(a, table[i - 1][j]) + 1;
                }
            }
        }
        System.out.println("DP table looks like this: ");
        for(int[] arr: table){
            System.out.println(Arrays.toString(arr));
        }
        return table[m][n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String s1 = input.nextLine();
        System.out.println("Enter second string: ");
        String s2 = input.nextLine();

        System.out.println("Total operation require: " + editDistance(s1, s2));
    }
}
