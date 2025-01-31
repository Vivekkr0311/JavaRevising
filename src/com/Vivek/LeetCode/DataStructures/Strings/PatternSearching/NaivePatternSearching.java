package com.Vivek.LeetCode.DataStructures.Strings.PatternSearching;

import java.util.ArrayList;
import java.util.Scanner;

public class NaivePatternSearching {

    private static ArrayList<Integer> patternSearch(String pattern, String input){
        if(pattern.isEmpty()){
            return new ArrayList<>();
        }

        if(input.isEmpty()){
            return new ArrayList<>();
        }

        int m = pattern.length();
        int n = input.length();

        ArrayList<Integer> answers = new ArrayList<>();
        for(int i = 0; i <= n - m; i++){
            if(input.substring(i, i + m).equalsIgnoreCase(pattern)){
                answers.add(i);
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the pattern: ");
        String pattern = scanner.nextLine();
        System.out.println("Enter the input: ");
        String input = scanner.nextLine();

        System.out.println("Pattern " + pattern + " is present in indexes " + patternSearch(pattern, input));
    }
}
