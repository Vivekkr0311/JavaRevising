package com.Vivek.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class MaximumLengthSubstringWithTwoOccurrences {
    private static boolean areEachCharacterAtMostOnce(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(Character key : map.keySet()){
            if(!(map.get(key) <= 2)){
                return false;
            }
        }
        return true;
    }

    private static int maximumLengthSubstringBruteForce(String s){
        int n = s.length();
        int ansLength = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int currLength = j - i + 1;
                if(areEachCharacterAtMostOnce(s.substring(i, j + 1))){
                    if(currLength > ansLength){
                        ansLength = currLength;
                    }
                }
            }
        }
        return ansLength;
    }

    private static int maximumLengthSubstring(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        int left = 0;
        int right = 0;
        int ansLength = 0;

        while(right < n){
            int freq = map.getOrDefault(s.charAt(right), 0);

            if(freq + 1 > 2){
                left++;
                right = left;
                map.clear();
            }else{
                map.put(s.charAt(right), freq + 1);
                right++;
            }

            int currLength = right - left;
            if(currLength > ansLength){
                ansLength = currLength;
            }
        }
        return ansLength;
    }

    private static int maximumLengthSubstring2(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.get(rightChar) > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input string: ");
        String input = scanner.nextLine();

//        System.out.println("Substring which has maximum length such that \nit also contains each character more than once: " + maximumLengthSubstringBruteForce(input));
//        System.out.println("Substring which has maximum length such that \nit also contains each character more than once: " + maximumLengthSubstring(input));
        System.out.println("Substring which has maximum length such that \nit also contains each character more than once: " + maximumLengthSubstring2(input));
    }
}
