package com.Vivek.LeetCode.DynamicProgramming.Number_of_Ways_to_Paint_N_x_3_Grid_1411.Tabulation;

import java.util.Scanner;

public class Number_of_ways_to_Paint_N_x_3_Grid_1411 {
    private static int numOfWays(int n) {
        final int MOD = 1_000_000_007;

        long a = 6;
        long b = 6;

        for (int i = 2; i <= n; i++) {
            long newA = (2 * a + 2 * b) % MOD;
            long newB = (2 * a + 3 * b) % MOD;
            a = newA;
            b = newB;
        }

        return (int)((a + b) % MOD);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows (n): ");
        int n = scan.nextInt();

        System.out.println("Number of ways to paint the " + n + " x 3 grid: " + numOfWays(n));
    }
}
