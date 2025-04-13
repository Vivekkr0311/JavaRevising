package com.Vivek.LeetCode.Recursion_BackTracking.BackTracking;

import java.util.ArrayList;
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

    static ArrayList<String> listPathWithDiag(String path, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(path);
            return ans;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r > 1 && c >1){
            list.addAll(listPathWithDiag(path + "D", r - 1, c -1));
        }
        if(r > 1){
            list.addAll(listPathWithDiag(path + "V", r - 1, c));
        }
        if(c > 1){
            list.addAll(listPathWithDiag(path + "H", r, c - 1));
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r, c;
        System.out.println("Enter row/ col: ");
        r = input.nextInt(); c = input.nextInt();

        printPath("", r, c);
        printPathDiagonal("", r, c);
        System.out.println(listPathWithDiag("", r, c));
    }
}
