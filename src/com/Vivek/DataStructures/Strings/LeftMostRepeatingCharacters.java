package com.Vivek.DataStructures.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LeftMostRepeatingCharacters {

    private static final int CHAR = 256;
    private static int leftMostRepeatingCharacter_Efficient_1(String s){
        int[] fIndex = new int[CHAR];
        Arrays.fill(fIndex, -1);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            int firstIndex = fIndex[s.charAt(i)];

            if(firstIndex == -1){
                fIndex[s.charAt(i)] = i;
            }else{
                res = Math.min(res, firstIndex);
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private static int leftMostRepeatingCharacter_Efficient_2(String s){
        boolean[] isVisited = new boolean[CHAR];
        int res = -1;
        for(int i = s.length() -1; i >= 0; i--){
            if(isVisited[s.charAt(i)]){
                res = i;
            }else{
                isVisited[s.charAt(i)] = true;
            }
        }
        return res;
    }

    private static int leftMostRepeatingCharacter(String s){
        if(s.isEmpty()){
            return -1;
        }

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!freqMap.containsKey(s.charAt(i))){
                freqMap.put(s.charAt(i), 1);
            }else{
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);
            }
        }

        for(int i = 0; i < s.length(); i++){
            int currFreq = freqMap.get(s.charAt(i));

            if(currFreq > 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String input = scanner.nextLine();

        System.out.println("Index of left most repeating character is: " + leftMostRepeatingCharacter(input));
        System.out.println("Index of left most repeating character is: " + leftMostRepeatingCharacter_Efficient_1(input));
        System.out.println("Index of left most repeating character is: " + leftMostRepeatingCharacter_Efficient_2(input));
    }
}
