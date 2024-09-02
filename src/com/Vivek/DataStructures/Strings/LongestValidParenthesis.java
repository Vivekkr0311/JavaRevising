package com.Vivek.DataStructures.Strings;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParenthesis {
    private static int longestValidParentheses(String input){
        int n = input.length();
        if (n == 0){
            return 0;
        }

        int left = 0;
        int right = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            char currChar = input.charAt(i);
            if(currChar == '('){
                left++;
            }else if(currChar == ')'){
                right++;
            }

            if(left == right){
                max = Math.max(max, left * 2);
            }else if(right > left){
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        max = 0;
        for(int i = n; i >= 0; i--){
            char currChar = input.charAt(i);
            if(currChar == '('){
                left++;
            }else if(currChar == ')'){
                right++;
            }

            if(left == right){
                max = Math.max(max, left * 2);
            }else if(right < left){
                left = 0;
                right = 0;
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