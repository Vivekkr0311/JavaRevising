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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r, c;
        System.out.println("Enter row/ col: ");
        r = input.nextInt(); c = input.nextInt();

        printPath("", r, c);
    }
}
