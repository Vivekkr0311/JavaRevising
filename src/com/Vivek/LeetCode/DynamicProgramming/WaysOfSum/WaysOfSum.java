package com.Vivek.LeetCode.DynamicProgramming.WaysOfSum;

import java.util.Arrays;
import java.util.Scanner;
public class WaysOfSum {

    static int waysOfSum(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for(int i = 1; i < n; i++){
            for(int j = i; j <= n; j++){
                dp[j] = dp[j] + dp[j - i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    static int recursiveSol(int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        int sub_res = 0;
        for (int i = 1; i <= n; i++) {
            sub_res = sub_res + recursiveSol(n - i);
        }
        return sub_res;
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = input.nextInt();
        System.out.println("Number of ways you can represent: " + n + ": " + waysOfSum(n));
        System.out.println("Number of ways you can represent: " + n + ": " + recursiveSol(n));
    }
}
