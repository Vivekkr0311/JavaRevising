package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.Recursion.SimpleProblemsUsingRecursion.PatternProblems;

import java.util.Scanner;

public class PatternProblem {

    static void upperTriangle(int row, int col){
        if(row == 0){
            System.out.println(" <--- Upper Triangle above printed ---> ");
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

    static void lowerTriangle(int row, int col){
        if(row == 0){
            System.out.println(" <--- Lower Triangle above printed ---> ");
            return;
        }

        if(row > col){
            lowerTriangle(row, col  + 1);
            System.out.print("* ");
        }else{
            //row == col
            lowerTriangle(row - 1, 0);
            System.out.println();
        }
    }

    static void printPattern(int n){
        upperTriangle(n, 0);
        lowerTriangle(n, 0);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of row/ col: ");
        int n = input.nextInt();

        printPattern(n);
    }
}
