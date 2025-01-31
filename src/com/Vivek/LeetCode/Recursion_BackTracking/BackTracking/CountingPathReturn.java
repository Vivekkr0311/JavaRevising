package com.Vivek.LeetCode.Recursion_BackTracking.BackTracking;

import java.util.Scanner;

public class CountingPathReturn {

    static int countPath(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int left = countPath(r - 1, c);
        int right = countPath(r, c - 1);

        return left + right;
    }

    static int countPathWithDiag(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int left = countPathWithDiag(r - 1, c);
        int right = countPathWithDiag(r, c - 1);
        int middle = countPathWithDiag(r - 1, c - 1);

        return left + right + middle;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r, c;
        System.out.println("Enter row/ col: ");
        r = input.nextInt(); c = input.nextInt();

        System.out.println("Number of path: " + countPath(r, c));
        System.out.println("Number of paths including diagonal: " + countPathWithDiag(r, c));
    }
}
