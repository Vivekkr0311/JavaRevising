package com.Vivek.ArraysAndArrayLists.SlidingWindow;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input string: ");
        String input = scanner.nextLine();

        System.out.println("Substring which has maximum length such that \nit also contains each character more than once: " + maximumLengthSubstringBruteForce(input));
    }
}
