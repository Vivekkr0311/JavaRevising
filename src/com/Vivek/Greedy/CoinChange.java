package com.Vivek.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {

    static void reverse(int[] arr){
        int forward = 0;
        int backward = arr.length - 1;

        while(forward <= backward){
            int temp = arr[forward];
            arr[forward] = arr[backward];
            arr[backward] = temp;
            forward++;
            backward--;
        }
    }

    static int minimumCoinRequired(int[] coins, int sum){
        Arrays.sort(coins);
        reverse(coins);

        int numberOfCoins = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= sum){
                float c = (float)Math.floor(sum/coins[i]);
                numberOfCoins += c;
                sum -= c * coins[i];
            }
            if(sum == 0){
                break;
            }
        }
        return numberOfCoins;
    }

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        System.out.println("Enter number of coins you have: ");
        int n = input.nextInt();
        int[] coins = new int[n];

        System.out.println("Enter your coins: ");
        for(int i = 0; i < n; i++){
            coins[i] = input.nextInt();
        }

        System.out.println("Enter the sum you wanna make of using these coins: ");
        int sum = input.nextInt();
        System.out.println("Minium number coins required to make " + sum + " using coins " + Arrays.toString(coins) + " is " + minimumCoinRequired(coins, sum));
    }
}
