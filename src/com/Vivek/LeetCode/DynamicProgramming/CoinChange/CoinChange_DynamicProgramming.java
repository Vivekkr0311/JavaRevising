package com.Vivek.LeetCode.DynamicProgramming.CoinChange;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange_DynamicProgramming {

    static int coinChange(int[] coins, int sum){
        int[][] table =  new int[coins.length + 1][sum +1];

        for(int i = 0; i < coins.length + 1; i++){
            // This represents, how many ways are there to make sum '0' using coins[i], i = 0, 1, 2 ... all coins.
            // 1 way right ?? We will not take any coin then we will be able to make sum '0'.
            // This is why, we are assigning 1 here.
            table[i][0] = 1;
        }

        // Below loop is not required in java as all values by default will have '0'.
        // But the sake of understanding this algorithm, I am keeping it here ;)
        for(int i = 1; i < sum + 1; i++){
            // This represents, having '0' coins, how many ways are there to make sum i = 0, 1, 2, 3, 4, 5.. till sum.
            // '0' ways right ?? so this is why we are assigning '0's here.
            table[0][i] = 0;
        }

        for(int i = 1; i < coins.length + 1; i++){
            // table[i][j]: represent how many ways are there you can make the sum 'j' using coins from coins[i - 1] to coins[0].
            for(int j = 1; j < sum + 1; j++){
               if(coins[i - 1] <= j){ // if current coin coins[i - 1] is <= to the sum, we can make the sum 'j' using this coin 'coin[i -1]'.
                   table[i][j] = table[i][j - coins[i - 1]] + table[i - 1][j];
                   // table[i][j]: is computed using if we consider the coin 'coin[i -1]', sum will decrement 'j - coin[i -1]' using this coin
                   // and (plus) if we don't consider this coin, sum (j) will be intact. We find ways of both these condition and sum it.
                   // like we did in the recursion solution.
               }else{
                   // We current coin is greater than the sum, simply ignore this coin, then sum (j) will be as it is.
                   table[i][j] = table[i -1][j];
               }
            }
        }

        for(int[] temp : table){
            System.out.println(Arrays.toString(temp));
        }
        return table[coins.length][sum];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many coins do you have? ");
        int n = input.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter each coin: ");
        for(int i = 0; i < n; i++){
            coins[i] = input.nextInt();
        }
        System.out.println("What is the sum you wanna make up using these coins ? ");
        int sum = input.nextInt();
        int ans = coinChange(coins, sum);
        System.out.println("Number ways you can make the sum " +  sum + " using coins " + Arrays.toString(coins) + " are " + ans);
    }
}
