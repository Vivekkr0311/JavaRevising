package com.Vivek.LeetCode.DataStructures.Strings;

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

    private static boolean isPalindrome(String s) {
        int forwardIdx = 0;
        int backwardIdx = s.length() - 1;

        while(forwardIdx < backwardIdx){

            // skipping special characters
            while (forwardIdx < backwardIdx && !Character.isLetterOrDigit(s.charAt(forwardIdx))) {
                forwardIdx++;
            }
            while (forwardIdx < backwardIdx && !Character.isLetterOrDigit(s.charAt(backwardIdx))) {
                backwardIdx--;
            }
            
            if (Character.toLowerCase(s.charAt(forwardIdx)) != Character.toLowerCase(s.charAt(backwardIdx))) {
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
