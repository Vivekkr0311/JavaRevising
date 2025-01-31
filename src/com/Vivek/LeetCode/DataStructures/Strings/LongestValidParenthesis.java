package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Scanner;

public class LongestValidParenthesis {
    private static int longestValidParentheses(String input){
        int n = input.length();
        if (n == 0){
            return 0;
        }

        int openingParenthesesCount = 0;
        int closingParenthesesCount = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            char currChar = input.charAt(i);
            if(currChar == '('){
                openingParenthesesCount++;
            }else if(currChar == ')'){
                closingParenthesesCount++;
            }

            if(openingParenthesesCount == closingParenthesesCount){
                max = Math.max(max, openingParenthesesCount * 2);
            }else if(closingParenthesesCount > openingParenthesesCount){
                openingParenthesesCount = 0;
                closingParenthesesCount = 0;
            }
        }

        openingParenthesesCount = 0;
        closingParenthesesCount = 0;
        for(int i = n - 1; i >= 0; i--){
            char currChar = input.charAt(i);
            if(currChar == '('){
                openingParenthesesCount++;
            }else if(currChar == ')'){
                closingParenthesesCount++;
            }

            if(openingParenthesesCount == closingParenthesesCount){
                max = Math.max(max, openingParenthesesCount * 2);
            }else if(closingParenthesesCount < openingParenthesesCount){
                openingParenthesesCount = 0;
                closingParenthesesCount = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string with parenthesis: ");
        String s = scanner.nextLine();

        System.out.println("Longest valid parenthesis: " + longestValidParentheses(s));
    }
}