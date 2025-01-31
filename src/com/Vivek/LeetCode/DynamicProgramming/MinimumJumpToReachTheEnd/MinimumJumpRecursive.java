package com.Vivek.LeetCode.DynamicProgramming.MinimumJumpToReachTheEnd;

import java.util.Scanner;
public class MinimumJumpRecursive {

    static int minimumJump(int[] jumpArray, int n){
        if(n == 1){
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= n - 2; i++){
            if(i + jumpArray[i] >=  n - 1){

                int sub_res= minimumJump(jumpArray, i + 1);

                if(sub_res != Integer.MAX_VALUE){
                    res = Math.min(res, sub_res + 1);
                }
            }
        }
        return res;
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

        System.out.println("Minimum jump we can make to reach the end: " + minimumJump(jumpArray, jumpArray.length));
    }
}
