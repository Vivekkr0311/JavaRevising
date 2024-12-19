package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubstringsOfSizeThreeWithDistinctCharacters {
    private static int countGoodSubStrings(String s){
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Number of good substring in " + s + " is " + countGoodSubStrings(s));
    }
}