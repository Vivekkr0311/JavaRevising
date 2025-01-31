package com.Vivek.LeetCode.Greedy;

import java.util.Scanner;

public class JumpGame {

    static int jumpReq(int[] arr, int startIdx){
        int jump = 0;
        while(startIdx < arr.length){
            if(arr[startIdx] == 0){ return -1; }
            startIdx = startIdx + arr[startIdx];
            jump++;
        }
        return jump;
    }

    static int findMinium(int[] arr){
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < temp){
                temp = arr[i];
            }
        }
        return temp;
    }

    static int jumpGame(int[] arr){
        int min = Integer.MAX_VALUE;
        int[] ans = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            int temp = jumpReq(arr, i);
            if(temp == -1){
                continue;
            }
//             if(min > temp){
//                 min = temp;
//             }
            ans[i] = temp;
        }
        min = findMinium(ans);
        return min;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = input.nextInt();

        System.out.println("Enter jump for each: ");
        int[] jumps = new int[n];
        for(int i = 0; i < n; i++){
            jumps[i] = input.nextInt();
        }

        System.out.println("Minimum jump: " + jumpGame(jumps));
    }
}
