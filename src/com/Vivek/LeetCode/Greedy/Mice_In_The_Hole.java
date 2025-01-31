package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Mice_In_The_Hole {

    static int miceInTheHole(int[] mice, int[] holes){
        Arrays.sort(mice);
        Arrays.sort(holes);

        int[] ans = new int[mice.length];
        for(int i = 0; i < mice.length; i++){
            ans[i] = Math.abs(holes[i] - mice[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int x : ans){
            if(x > max){
                max = x;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of mice");
        int n = input.nextInt();
        int[] mice =  new int[n];
        for(int i = 0; i < n; i++){
            mice[i] = input.nextInt();
        }

        System.out.println("Enter holes: ");
        int[] holes = new int[n];
        for(int i = 0; i < n; i++){
            holes[i] = input.nextInt();
        }

        System.out.println(miceInTheHole(mice, holes));
    }
}
