package com.Vivek.Recursion.SimpleProblemsUsingRecursion.SubSetProblem;

import java.util.Scanner;

public class StringSubset {

    static void subset(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println("'" + processed + "'");
            return;
        }

        subset(processed + unprocessed.charAt(0), unprocessed.substring(1));
        subset(processed, unprocessed.substring(1));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert input string: ");
        String str = input.nextLine();

        subset("", str);
    }
}
