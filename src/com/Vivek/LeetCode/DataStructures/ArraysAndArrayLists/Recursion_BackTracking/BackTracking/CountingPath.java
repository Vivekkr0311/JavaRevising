package com.Vivek.LeetCode.Recursion_BackTracking.BackTracking;

import java.util.Scanner;

public class CountingPath {

    static int path = 0;
    static void countingPath(int r, int c){
        if(c == 1 || r == 1) {
            path += 1;
            return;
        }

        countingPath(r - 1, c);
        countingPath(r, c - 1);
    }

    static void countingPathDiag(int r, int c){
        if(c == 1 || r == 1) {
            path += 1;
            return;
        }

        countingPathDiag(r - 1, c);
        countingPathDiag(r, c - 1);
        countingPathDiag(r - 1, c - 1);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r, c;
        System.out.println("Enter row and col: ");
        r = input.nextInt(); c = input.nextInt();
//        countingPath(r, c);
        countingPathDiag(r, c);
        System.out.println("Total number of path(s): " + path);
    }
}
