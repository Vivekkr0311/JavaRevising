package com.Vivek.LeetCode.ConditionsAndLoop;

import java.util.Scanner;
public class ConditionsAndLoops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("[?] Input # of iteration. ");
        int n = in.nextInt();

        System.out.println();
        for(int i = 1; i <=  n; i++){
            System.out.println("[+] Just printing number of iterations "  + i);
        }
    }
}
