package com.Vivek.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestNiceSubstring {
    private static boolean checkNice(String s){
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i) + 0);
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                int expectedCharAscii = ch - 32;
                if(!set.contains(expectedCharAscii)){
                    return false;
                }
            }else if(ch >= 'A' && ch <= 'Z'){
                int expectedCharAscii = ch + 32;
                if(!set.contains(expectedCharAscii)){
                    return false;
                }
            }
        }
        return true;
    }

    private static String longestNiceSubstringBruteForce(String s){
        int n = s.length();
        String ans = "";
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                String subString = s.substring(i, j + 1);
                boolean isNice = checkNice(subString);

                if(isNice){
                    if(subString.length() > ans.length()){
                        ans = subString;
                    }
                }
            }
        }
        return ans;
    }

    private static boolean isNice(Set<Character> lowerCase, Set<Character> upperCase){
        for(char ch : lowerCase){
            char upperCaseVersion = Character.toUpperCase(ch);
            if(!(upperCase.contains(upperCaseVersion))){
                return false;
            }
        }

        for(char ch : upperCase){
            char lowerCaseVersion = Character.toLowerCase(ch);

            if(!(lowerCase.contains(lowerCaseVersion))){
                return false;
            }
        }
        return true;
    }

    private static String longestNiceSubstring(String s){
        int n = s.length();
        String ans = "";
        for(int start = 0; start < n; start++){
            Set<Character> lowerCase = new HashSet<>();
            Set<Character> upperCase = new HashSet<>();

            for(int end = start; end < n; end++){
                char ch = s.charAt(end);
                if(Character.isLowerCase(ch)){
                    lowerCase.add(ch);
                }else if(Character.isUpperCase(ch)){
                    upperCase.add(ch);
                }

                if(isNice(lowerCase, upperCase)){
                    if(end - start + 1 > ans.length()){
                        ans = s.substring(start, end + 1);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = scanner.nextLine();

        System.out.println("Longest nice substring is: " + longestNiceSubstringBruteForce(s));
        System.out.println("Longest nice substring is: " + longestNiceSubstring(s));
    }
}
