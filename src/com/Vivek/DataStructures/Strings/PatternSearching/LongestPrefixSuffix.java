package com.Vivek.DataStructures.Strings.PatternSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LongestPrefixSuffix {


    private static long longestPrefixSuffix(String input, int n){
        for(int len = n - 1; len > 0; len--){
            boolean flag = true;
            for(int i = 0; i < len; i++){
                if(input.charAt(i) != input.charAt(n - len + i)){
                    flag = false;
                }
            }

            if(flag){
                return len;
            }
        }
        return 0;
    }

    private static ArrayList<Long> fillLongestProperPrefixSuffix(String input){
        ArrayList<Long> res = new ArrayList<>();
        int n = input.length();
        for(int i = 0; i < n; i++){
            res.add(longestPrefixSuffix(input, i + 1));
        }
        return res;
    }

    private static void longestPrefixSuffix_Efficient(String input, int[] lps){
        lps[0] = 0;
        int i = 1;
        int n = input.length();
        int len = 0;

        while(i < n){
            if(input.charAt(i) == input.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    len = lps[len - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String input = scanner.nextLine();

        System.out.println("Longest prefix suffix for each idx of " + input + " are " + fillLongestProperPrefixSuffix(input));
        int[] lps = new int[input.length()];
        longestPrefixSuffix_Efficient(input, lps);
        System.out.println("Longest prefix suffix for each idx of " + input + " are " + Arrays.toString(lps));
    }
}
