package com.Vivek.DynamicProgramming.MinimumCoinsToMakeASum;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumCoinsDP {

    static int minimumCoins(int[] coins, int sum){
        int[] intermediateSum = new int[sum + 1];
        Arrays.fill(intermediateSum, Integer.MAX_VALUE);
        intermediateSum[0] = 0; // for sum = 0, we need 0 coins.

        for(int i = 1; i < intermediateSum.length; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){ // if current coins is less than the curr sum 'i'
                    int sub_res = intermediateSum[i -  coins[j]];
                    if(sub_res != Integer.MAX_VALUE){
                        intermediateSum[i] = Math.min(
                                intermediateSum[i], // curr sum
                                sub_res + 1 // sum when we use the coin
                        );
                    }
                    // then the coin required -> 'i', for sum intermediateSum[i], will minimum of above two values.
                }
            }
        }
        return intermediateSum[intermediateSum.length - 1];
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
