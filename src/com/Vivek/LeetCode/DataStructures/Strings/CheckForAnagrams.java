package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class CheckForAnagrams {

    // works only for small letters
    private static boolean areAnagrams(String s1, String s2){
        int l = s1.length();
        int m = s2.length();

        if(l != m){
            return false;
        }

        int[] freqArray = new int[26];
        for(int i = 0; i < s1.length(); i++){
            freqArray[s1.charAt(i) - 97] += 1;
        }

        for(int i = 0; i < s2.length(); i++){
            freqArray[s2.charAt(i) - 97] -= 1;
        }

        for(int i = 0; i < 26; i++){
            if(freqArray[i] != 0){
                return false;
            }
        }
        return true;
    }

    private static boolean areAnagramsOptimized(String s1, String s2){
        int l = s1.length();
        int m = s2.length();

        if(l != m){
            return false;
        }

        int[] count = new int[256];

        for(int i = 0; i < s1.length(); i++){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for(int i = 0; i < 256; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }

    private static boolean areAnagramsBruteForce(String s1, String s2){
        int l = s1.length();
        int m = s2.length();

        if(l != m){
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        String s1_Sorted = new String(s1Array);
        String s2_Sorted = new String(s2Array);
        return s1_Sorted.equals(s2_Sorted);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.println("Enter second string: ");
        String s2 = scanner.nextLine();

        System.out.println("Both strings " + s1 + " and " + s2 + " are Anagrams: " + areAnagrams(s1, s2));
        System.out.println("Both strings " + s1 + " and " + s2 + " are Anagrams: " + areAnagramsBruteForce(s1, s2));
        System.out.println("Both strings " + s1 + " and " + s2 + " are Anagrams: " + areAnagramsOptimized(s1, s2));
    }
}
