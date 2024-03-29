package com.Vivek.DynamicProgramming.MinimumCoinsToMakeASum;

import java.util.Scanner;

public class MinimumCoinsRecursive {

    static int minimumCoins(int[] coins, int sum){
        if(sum == 0){
            return 0;
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= sum){
                int sub_res = minimumCoins(coins, sum - coins[i]);
                if(sub_res != Integer.MAX_VALUE){
                    res = Math.min(res, sub_res + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many coins do you have ??");
        int n = input.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter each coin: ");
        for(int i = 0; i < n; i++){
            coins[i] = input.nextInt();
        }

        System.out.println("Enter the sum you want to make: ");
        int sum = input.nextInt();
        System.out.println("Minimum number of coins will be: " + minimumCoins(coins, sum));
    }
}
