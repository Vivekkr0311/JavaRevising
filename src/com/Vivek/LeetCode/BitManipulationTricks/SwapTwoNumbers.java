package com.Vivek.LeetCode.BitManipulationTricks;

import java.util.Scanner;

public class SwapTwoNumbers {

    static int[] swap(int first, int second){
        first = first ^ second;
        second = first ^ second;
        first = first ^ second;
        return new int[]{first, second};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int first = input.nextInt();
        System.out.println("Enter second number: ");
        int second = input.nextInt();

        int[] ans = swap(first, second);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
