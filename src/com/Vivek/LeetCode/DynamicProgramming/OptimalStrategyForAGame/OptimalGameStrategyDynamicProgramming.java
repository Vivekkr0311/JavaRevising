package com.Vivek.LeetCode.DynamicProgramming.OptimalStrategyForAGame;

import java.util.Arrays;
import java.util.Scanner;

public class OptimalGameStrategyDynamicProgramming {

    static int opitmalGameStrategyDP(int[] arr){
        int[][] dp = new int[arr.length][arr.length];

        for(int i = 0; i < dp.length - 1; i++){
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        }

        for(int gap = 3; gap < arr.length; gap += 2){
            for(int i = 0; i + gap < arr.length; i++){
                int j = i + gap;
                dp[i][j] = Math.max(
                        arr[i] + Math.min(
                                    dp[i + 2][j],
                                    dp[i + 1][j - 1]
                        ),
                        arr[j] + Math.min(
                                dp[i + 1][j - 1],
                                dp[i][j - 2]
                        )
                );
            }
        }

        for(int[] arr2 : dp){
            System.out.println(Arrays.toString(arr2));
        }
        return dp[0][arr.length - 1];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Optimal strategy win score is: " + opitmalGameStrategyDP(arr));
    }
}
