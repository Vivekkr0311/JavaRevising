package com.Vivek.LeetCode.DynamicProgramming;

import java.util.Scanner;

public class DominoAndTrominoTilinig_790 {

    private static int numTilings(int n) {
        int MOD = 1000000007;
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }


        return (2 * numTilings(n - 1) % MOD + numTilings(n - 3)) % MOD;
    }

    private static int numTilings_(int n) {
        int MOD = 1000000007;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3]) % MOD;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println("Number of ways to tile a 2 x " + n + " board: " + numTilings(n));
        System.out.println("Number of ways to tile a 2 x " + n + " board: " + numTilings_(n));
    }
}
