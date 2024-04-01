package com.Vivek.DynamicProgramming.Knapsack_0_1;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;
public class RecursiveKnapsack_0_1 {

    static int knapsack(int W, int[] wt, int[] pr, int n){
        if(n == 0 || W == 0){
            return 0;
        }

        if(wt[n - 1] > W){
            return knapsack(W, wt, pr, n - 1);
        }else{
            return Math.max(
                    knapsack(W, wt, pr, n - 1),
                    pr[n -1] + knapsack(W - wt[n - 1], wt, pr, n - 1)
            );
        }
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
