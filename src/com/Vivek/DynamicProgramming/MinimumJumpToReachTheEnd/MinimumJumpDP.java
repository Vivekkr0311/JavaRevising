package com.Vivek.DynamicProgramming.MinimumJumpToReachTheEnd;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumJumpDP {

    static int minimumJump(int[] jumps){
        int[] dp = new int[jumps.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(jumps[j] + j >= i){
                    if(dp[j] != Integer.MAX_VALUE){
                        dp[i] = Math.min(
                                dp[i],
                                dp[j] + 1
                        );
                    }
                }
            }
        }
        return dp[jumps.length - 1];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many jump vector? ");
        int n = input.nextInt();

        int[] jumpArray = new int[n];
        System.out.println("Enter each jump vector: ");
        for(int i = 0; i < n; i++){
            jumpArray[i] =  input.nextInt();
        }

        System.out.println("Minimum jump we can make to reach the end: " + minimumJump(jumpArray));
    }
}
