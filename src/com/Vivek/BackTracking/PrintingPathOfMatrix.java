package com.Vivek.BackTracking;

import java.util.Scanner;

public class PrintingPathOfMatrix {

    static void printPath(String path, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(path);
            return;
        }

        if(r > 1) printPath(path + "D", r - 1, c);
        if(c > 1) printPath(path + "R", r, c - 1);
    }

    static void printPathDiagonal(String path, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(path);
            return;
        }

        if(c > 1 && r > 1) printPath(path + "D", r, c - 1);
        if(r > 1) printPath(path + "V", r - 1, c);
        if(c > 1) printPath(path + "H", r, c - 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r, c;
        System.out.println("Enter row/ col: ");
        r = input.nextInt(); c = input.nextInt();

        printPath("", r, c);
        printPathDiagonal("", r, c);
    }
}
