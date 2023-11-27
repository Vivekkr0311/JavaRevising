package com.Vivek.Recursion.SimpleProblemsUsingRecursion.PatternProblems;

import java.util.Scanner;

public class PatternProblem {

    static void upperTriangle(int row, int col){
        if(row == 0){
            return;
        }

        if(row > col){
            System.out.print("* ");
            upperTriangle(row, col  + 1);
        }else{
            //row == col
            System.out.println();
            upperTriangle(row - 1, 0);
        }
    }
    static void printPattern(int n){
        upperTriangle(n, 0);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of row/ col: ");
        int n = input.nextInt();

        printPattern(n);
    }
}
