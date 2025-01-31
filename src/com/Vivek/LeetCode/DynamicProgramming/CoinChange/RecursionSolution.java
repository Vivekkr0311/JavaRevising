package com.Vivek.LeetCode.DynamicProgramming.CoinChange;

import java.util.Scanner;

public class RecursionSolution {
    static void coinChange(int[] coins, String output, int sum, int n){
        if(sum == 0){
            System.out.println("Coins you can use " + output);
            return;
        }
        if(sum < 0){
            return;
        }
        if(n == 0){
            return;
        }
        if(sum >= coins[n - 1]){
            coinChange(coins, output + " " + coins[n -1], sum - coins[n - 1], n -1);
        }
        coinChange(coins, output, sum, n - 1);
    }

    static int coinWays(int[] coins, int sum, int n){
        if(sum == 0){
            return 1;
        }
        if(sum < 0){
            return 0;
        }
        if(n == 0){
            return 0;
        }
        return coinWays(coins, sum - coins[n - 1], n -1) + coinWays(coins, sum, n - 1);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many coins do you have ?");
        int n = input.nextInt();
        System.out.println("Enter your coins: ");
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = input.nextInt();
        }
        System.out.println("Enter your sum you wanna make up using these coins: ");
        int sum = input.nextInt();
        coinChange(coins, "", sum, n);
        System.out.println("Total ways of you can make: " + coinWays(coins, sum, n));
    }
}
