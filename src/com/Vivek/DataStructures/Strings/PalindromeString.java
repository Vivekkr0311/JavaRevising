package com.Vivek.DataStructures.Strings;

import java.util.Scanner;

public class PalindromeString {

    private static boolean isPalindromeString(String s){
        int forwardIdx = 0;
        int backwardIdx = s.length() - 1;

        while(forwardIdx < backwardIdx){
            if(s.charAt(forwardIdx) != s.charAt(backwardIdx)){
                return false;
            }
            forwardIdx++;
            backwardIdx--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String input = scanner.nextLine();

        System.out.println(input + " is a palindrome: " + isPalindromeString(input));
    }
}
