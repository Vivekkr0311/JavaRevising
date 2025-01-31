package com.Vivek.LeetCode.DynamicProgramming.Knapsack_0_1;

import java.util.Scanner;

public class DP_Knapsack_0_1 {

    static int knapsack(int W, int[] wt, int[] pr, int n){
        int[][] dp = new int[n + 1][W + 1];

        for(int i = 0; i <= W; i++){
            dp[0][i] = 0;
        }

        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(j < wt[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(
                            dp[i - 1][j], pr[i - 1] + dp[i - 1][j - wt[i - 1]]
                    );
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many elements do you have? ");
        int n = input.nextInt();
        System.out.println("Enter weights of each item: ");
        int[] wt = new int[n];
        for(int i = 0; i < n; i++){
            wt[i] = input.nextInt();
        }
        System.out.println("Enter profits of each item: ");
        int[] pr = new int[n];
        for(int i = 0; i < n; i++){
            pr[i] = input.nextInt();
        }

        System.out.println("Enter total W at most you can carry: ");
        int W = input.nextInt();
        System.out.println("Profit you can get is: " + knapsack(W, wt, pr, n));
    }
}
