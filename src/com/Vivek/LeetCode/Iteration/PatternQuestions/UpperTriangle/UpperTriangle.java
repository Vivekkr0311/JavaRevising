package com.Vivek.LeetCode.Iteration.PatternQuestions.UpperTriangle;

import java.util.Scanner;

public class UpperTriangle {
    static void upperTriangle(int n){
        int row = n;
        for(int i = row; i > 0; i--){
            for(int col = 0; col < row; col++){
                System.out.print("* ");
            }
            row--;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        upperTriangle(n);
    }
}
