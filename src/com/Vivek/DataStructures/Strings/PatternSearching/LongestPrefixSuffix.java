package com.Vivek.DataStructures.Strings.PatternSearching;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestPrefixSuffix {

    private static ArrayList<String> getSuffix(String s){
        ArrayList<String> suffix = new ArrayList<>();

        int n = s.length();
        for(int i = n; i >= 0; i--){
            suffix.add(s.substring(i, n));
        }
        return suffix;
    }

    private static ArrayList<String> getPrefix(String s){
        ArrayList<String> prefix = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            prefix.add(s.substring(0, i));
        }
        return prefix;
    }

    private static ArrayList<Integer> longestPrefixSuffix(String input){
        int n = input.length();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String subStr = input.substring(0, i);
            ArrayList<String> prefix = getPrefix(subStr);
            ArrayList<String> suffix = getSuffix(subStr);

            System.out.println("\nSubstring: " + subStr);
            System.out.println("Prefix:" + prefix);
            System.out.println("Suffix:" + suffix);
            for(String pre : prefix){
                for(String suff : suffix){
                    if(pre.equalsIgnoreCase(suff)){
                        res.add(pre.length());
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String input = scanner.nextLine();

        System.out.println("Longest prefix suffix for each idx of " + input + " are " + longestPrefixSuffix(input));
    }
}
