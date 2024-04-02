package com.Vivek.DynamicProgramming.OptimalStrategyForAGame;

import java.util.Scanner;

public class RecursiveCode {

    static int getMaxAndWin(int[] arr){
        // This code is to just win.
        int sumEven = 0;
        int sumOdd = 0;
        for(int i = 1; i <= arr.length - 1; i = i + 2){
            sumEven = sumEven + arr[i];
        }
        for(int i = 0; i <= arr.length - 1; i = i + 2){
            sumOdd = sumOdd + arr[i];
        }

        int max = Math.max(sumEven, sumOdd);
        // Whatever is the maximum, we will take that corner, and we will wim.
        // If sumOdd is maxium, we will take only one side of array which will be odd indexed elements.
        // If sumEven is maxium, we will take only other side of array always, which will be even indexed elements.
        // Hence, the ans will be maximum of these two.
        if (sumEven == sumOdd) {
            System.out.println("Match is tied!!");
        } else if (max == sumEven) {
            System.out.println("Always taking one side of even index will lead to winning!!");
        } else if (max == sumOdd) {
            System.out.println("Always taking one side of odd index will lead to winning!!");
        }
        return max;
    }

    static int optimalStrategy(int[] arr, int forward, int backward){
        // This different than winning the game.
        // We want maximum.
        if(forward + 1 == backward){
            return Math.max(arr[forward], arr[backward]);
        }

        if(forward < backward) {
            return Math.max(
                    arr[forward] + optimalStrategy(arr, forward + 1, backward),
                    arr[backward] + optimalStrategy(arr, forward, backward - 1)
            );
        }else{
            return arr[forward];
        }
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
//        System.out.println("Maximum you can get: " + optimalStrategy(arr, 0, arr.length - 1));
        System.out.println("Winning: " + getMaxAndWin(arr));
    }
}
