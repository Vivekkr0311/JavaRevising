package com.Vivek.LeetCode.DynamicProgramming.Number_of_Ways_to_Paint_N_x_3_Grid_1411.Memoization;

import java.util.Scanner;

public class Number_of_Ways_to_Paint_N_x_3_Grid_1411_Memoization {
    private static int helper(int idx, int n, int MOD,  Integer[][][][] dp, int p1, int p2, int p3) {
        if (idx == n) return 1;

        if (dp[idx][p1][p2][p3] != null) return dp[idx][p1][p2][p3];

        int ways = 0;
        for (int c1 = 0; c1 < 3; c1++) {
            for (int c2 = 0; c2 < 3; c2++) {
                for (int c3 = 0; c3 < 3; c3++) {
                    if (c1 != c2 && c2 != c3 && c1 != p1 && c2 != p2 && c3 != p3) {
                        ways += helper(idx + 1, n, MOD, dp, c1, c2, c3);
                        ways = ways % MOD;
                    }
                }
            }
        }

        dp[idx][p1][p2][p3] = ways;
        return ways;
    }

    private static int numOfWays(int n) {
        int MOD = 1_000_000_007;
        Integer[][][][] dp = new Integer[n][3][3][3];

        int ans = 0;
        for (int c1 = 0; c1 < 3; c1++) {
            for (int c2 = 0; c2 < 3; c2++) {
                for (int c3 = 0; c3 < 3; c3++) {
                    if (c1 != c2 && c2 != c3) {
                        ans = (ans + helper(1, n, MOD, dp, c1, c2, c3)) % MOD;
                    }
                }
            }
        }

        return ans % MOD;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows (n): ");
        int n = scan.nextInt();

        System.out.println("Number of ways to paint the " + n + " x 3 grid: " + numOfWays(n));
    }
}
