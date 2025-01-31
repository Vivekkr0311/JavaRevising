package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(!stack.isEmpty()){
                if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop();
                }else if(stack.peek() == '{' && s.charAt(i) == '}'){
                    stack.pop();
                }else if(stack.peek() == '[' && s.charAt(i) == ']'){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the parenthesis: ");
        String s = scanner.nextLine();

        System.out.println(s + " is balanced: " + isValid(s));
    }
}
