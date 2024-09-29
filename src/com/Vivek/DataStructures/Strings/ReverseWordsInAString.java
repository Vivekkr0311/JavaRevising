package com.Vivek.DataStructures.Strings;

import java.util.Scanner;
import java.util.Stack;

public class ReverseWordsInAString {

    private static void reverse(char[] arr, int forwardIdx, int backwardIdx){
        while(forwardIdx <= backwardIdx){
            char temp = arr[forwardIdx];
            arr[forwardIdx] = arr[backwardIdx];
            arr[backwardIdx] = temp;
            forwardIdx++;
            backwardIdx--;
        }
    }

    private static String reverseWordInAString(String s){
        if(s.isEmpty()){
            return s;
        }

        char[] str = s.toCharArray();
        int n = str.length;
        int start = 0;
        for(int end = 0; end < n; end++){
            if(str[end] == ' '){
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }

        // individual words are reversed
        reverse(str, start, n - 1);

        // now entire string is being reversed
        reverse(str, 0, n - 1);
        String ans = "";
        for(char c : str){
            ans = ans + c;
        }
        return ans;
    }

    private static String reverseWordInAString_naive_two(String s){
        if(s.isEmpty()){
            return s;
        }

        String[] words = s.split(" ");
        Stack<String> stackOfWords = new Stack<>();
        for(String w : words){
            stackOfWords.push(w);
        }

        String ans = "";
        while(!stackOfWords.isEmpty()){
            ans += stackOfWords.pop() + " ";
        }
        return ans;
    }

    private static String reverseWordInAString_naive_one(String s){
        if(s.isEmpty()){
            return s;
        }

        String[] words = s.split(" ");
        int forwardIdx = 0;
        int backwardIdx = words.length - 1;

        while(forwardIdx < backwardIdx){
            String temp = words[forwardIdx];
            words[forwardIdx] = words[backwardIdx];
            words[backwardIdx] = temp;
            forwardIdx++;
            backwardIdx--;
        }

        StringBuilder sb = new StringBuilder();
        for(String t : words){
            sb.append(t + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = scanner.nextLine();

        System.out.println("Reversed string is: " + reverseWordInAString_naive_one(s));
        System.out.println("Reversed string is: " + reverseWordInAString_naive_two(s));
        System.out.println("Reversed string is: " + reverseWordInAString(s));
    }
}