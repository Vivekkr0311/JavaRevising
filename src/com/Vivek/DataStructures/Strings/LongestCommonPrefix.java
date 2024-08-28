package com.Vivek.DataStructures.Strings;

import java.util.*;

public class LongestCommonPrefix {
    private static String longestCommonPrefix(String[] strings){
        if(strings.length == 0){
            return "";
        }

        String prefix = strings[0];
        int n = prefix.length();
        for(int i = 1; i < strings.length; i++){
            while(strings[i].indexOf(prefix) != 0){
                n = n - 1;
                prefix = prefix.substring(0, n);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many strings? ");
        int n = scanner.nextInt();

        String[] inputs = new String[n];
        System.out.println("Insert strings: ");
        for(int i = 0; i < n; i++){
            inputs[i] = scanner.next();
        }
        System.out.println("Longest Common Prefix: " + Arrays.toString(inputs) + " is " + longestCommonPrefix(inputs));
    }
}
