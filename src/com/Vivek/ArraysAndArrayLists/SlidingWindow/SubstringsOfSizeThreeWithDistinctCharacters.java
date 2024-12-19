package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubstringsOfSizeThreeWithDistinctCharacters {
    private static int countGoodSubStringsBruteForce(String s){
        int count = 0;
        for(int i = 0; i + 3 <= s.length(); i++){
            Set<Character> set = new HashSet<>();
            boolean isUnique = true;
            for(int j = i; j < i + 3; j++){
                char ch  = s.charAt(j);
                if(!set.contains(ch)){
                    set.add(ch);
                }else if(set.contains(ch)){
                    isUnique = false;
                    break;
                }
            }

            if(isUnique){
                count++;
            }
        }
        return count;
    }

    private static int countGoodSubStrings(String s){
        if(s.length() < 3){
            return 0;
        }

        int count = 0;
        for(int i = 0; i <= s.length() - 3; i++){
            char f = s.charAt(i);
            char sec = s.charAt(i + 1);
            char t = s.charAt(i + 2);

            if(f != sec && sec != t && f != t){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Number of good substring in " + s + " is " + countGoodSubStringsBruteForce(s));
        System.out.println("Number of good substring in " + s + " is " + countGoodSubStrings(s));
    }
}