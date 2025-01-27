package com.Vivek.DataStructures.ArraysAndArrayLists.DivideAndConquer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestNiceSubstring {
    private static String longestNiceSubstringDivideAndConquer(String s){
        if(s.length() < 2){
            return "";
        }
        Set<Character> set = new HashSet<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            set.add(s.charAt(i));
        }

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(!set.contains(Character.toLowerCase(ch)) || !set.contains(Character.toUpperCase(ch))){
                String left = longestNiceSubstringDivideAndConquer(s.substring(0, i));
                String right = longestNiceSubstringDivideAndConquer(s.substring(i + 1, n));

                return left.length() >= right.length() ? left : right;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = scanner.nextLine();

        System.out.println("Longest nice substring is: " + longestNiceSubstringDivideAndConquer(s));
    }
}
