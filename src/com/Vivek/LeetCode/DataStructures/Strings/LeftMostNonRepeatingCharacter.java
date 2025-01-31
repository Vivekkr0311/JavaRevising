package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class LeftMostNonRepeatingCharacter {

    private static final int CHAR = 256;
    private static int leftMostNonRepeatingCharacter_OneTraversal(String s){
        if(s.isEmpty()){
            return -1;
        }

        int[] firstIndex = new int[CHAR];
        Arrays.fill(firstIndex, -1);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            if(firstIndex[s.charAt(i)] == -1){
                firstIndex[s.charAt(i)] = i;
            }else{
                firstIndex[s.charAt(i)] = -2;
            }
        }

        for(int i = 0; i < CHAR; i++){
            if(firstIndex[i] >= 0){
                res = Math.min(res, firstIndex[i]);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int leftMostNonRepeatingCharacter(String s){
        if(s.isEmpty()){
            return -1;
        }

        int[] countCharArray = new int[CHAR];
        int res = -1;
        for(int i = s.length() - 1; i >= 0; i--){
            countCharArray[s.charAt(i)] += 1;
        }

        for(int i = 0; i < s.length(); i++){
            if(countCharArray[s.charAt(i)] == 1){
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String input = scanner.nextLine();

        System.out.println("Left most non repeating character is: " + leftMostNonRepeatingCharacter(input));
        System.out.println("Left most non repeating character is: " + leftMostNonRepeatingCharacter_OneTraversal(input));
    }
}
