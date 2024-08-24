package com.Vivek.DataStructures.Strings;

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

    private static String longestPalingdromeSubstring(String s){
        if(s == null || s.length() < 1){
            return "";
        }

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromMiddle(String s, int left, int right){
        if(s == null || left > right){
            return 0;
        }

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

//        System.out.println(allSubstring(s));
//        System.out.println("Length longest palindrome substring: " + longestPalingdromeSubstring_2(s));
        System.out.println("Length longest palindrome substring: " + longestPalingdromeSubstring(s));
    }
}