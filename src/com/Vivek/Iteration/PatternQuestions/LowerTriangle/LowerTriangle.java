package com.Vivek.Iteration.PatternQuestions.LowerTriangle;

import java.util.Scanner;

public class LowerTriangle {
    static void lowerTriangle(int n){
        int i = 1;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < i; col++){
                System.out.print("* ");
            }
            i++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        lowerTriangle(n);
    }
}
