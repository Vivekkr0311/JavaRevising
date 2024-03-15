package com.Vivek.DynamicProgramming.EditDistance;

import java.util.Scanner;

public class RecursiveSolution {
    static int editDistance(String s1, String s2, int m, int n){
        if(m == 0){
            return n;
        }

        if(n == 0){
            return m;
        }

        if(s1.charAt(m) == s2.charAt(n)){
            return editDistance(s1, s2, m - 1, n - 1);
        }else{
            int a = Math.min(editDistance(s1, s2, m - 1, n - 1), editDistance(s1, s2, m, n - 1));
            return Math.min(a, editDistance(s1, s2, m - 1, n - 1)) + 1;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String s1 = input.nextLine();
        System.out.println("Enter second string: ");
        String s2 = input.nextLine();

        System.out.println("Total operation require: " + editDistance(s1, s2, s1.length() - 1, s2.length() - 1));
    }
}
