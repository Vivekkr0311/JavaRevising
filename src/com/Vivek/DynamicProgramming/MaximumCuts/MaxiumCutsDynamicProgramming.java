package com.Vivek.DynamicProgramming.MaximumCuts;

import java.util.Scanner;

public class MaxiumCutsDynamicProgramming {

    static int maximumCutsDP(int n, int a, int b, int c){
        int[] dp = new int[n +  1];
        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            if((i - a) > 0){
                dp[i] = Math.max(dp[i], dp[i - a]);
            }
            if((i - b) > 0){
                dp[i] = Math.max(dp[i], dp[i - b]);
            }
            if((i - c) > 0){
                dp[i] = Math.max(dp[i], dp[i - c]);
            }

            if(dp[i] != -1){
                dp[i]++;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length of the rod: ");
        int rod = input.nextInt();
        System.out.println("Enter cuts length a/ b/ and /c: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        System.out.println("Maximum cuts that can be made on the rod of length: "  + rod + " using cuts: " + a + ", " + b + ",  and " + c + " is: " + maximumCutsDP(rod, a, b, c));
    }
}
