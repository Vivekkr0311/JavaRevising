package com.Vivek.ArraysAndArrayLists.SlidingWindow;

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

    private static String longestNiceSubstring(String s){
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = scanner.nextLine();

        System.out.println("Longest nice substring is: " + longestNiceSubstring(s));
    }
}
