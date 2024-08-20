package com.Vivek.DataStructures.StringQuestions;

import java.util.*;

public class LongestPalindromeSubstring {

    private static List<String> allSubstring(String s){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                list.add(s.substring(i, j));
            }
        }
        return list;
    }

    private static boolean isPlaingdrome(String s){
        int forward = 0;
        int backward = s.length() - 1;
        while(forward <=  backward){
            if(s.charAt(forward) == s.charAt(backward)){
                forward++;
                backward--;
            }else{
                return false;
            }
        }

        return true;
    }

    private static int longestPalingdromeSubstring_2(String s){
        List<String> allSubstring = allSubstring(s);
        int max = 0;
        for(String subString : allSubstring){
            if(isPlaingdrome(subString)){
                max = Math.max(max, subString.length());
            }
        }
        return max;
    }

    private static int longestPalingdromeSubstring(String s){
        int max = 0;
        int a_pointer = 0;
        int b_pointer = 0;

        int n = s.length();
        Set<Character> set = new HashSet<>();
        while(a_pointer < n && b_pointer < n){
            if(s.charAt(a_pointer) == s.charAt(b_pointer)){
                max = Math.max(max, max + 1);
                b_pointer++;
            }else{
                a_pointer++;
                b_pointer = a_pointer;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println(allSubstring(s));
        System.out.println("Length longest palindrome substring: " + longestPalingdromeSubstring_2(s));
    }
}