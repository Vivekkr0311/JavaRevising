package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Scanner;

public class Weighted_Word_Mapping_3838 {
    private static int getSumOfString(String str, int[] weights){
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            sum += weights[str.charAt(i) - 'a'];
        }
        return 'z' - (sum % 26);
    }

    private static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for(String word : words){
            ans.append((char) getSumOfString(word, weights));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of words you have: ");
        int n = scanner.nextInt();
        String[] words = new String[n];
        System.out.println("Enter the words: ");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }

        System.out.println("Enter the weights for the characters a, b, c, ... z");
        String weightsStr = scanner.next();
        weightsStr = weightsStr.substring(1, weightsStr.length() - 1);
        String[] arrChar = weightsStr.split(",");
        int[] weights = new int[arrChar.length];
        for (int i = 0; i < 26; i++) {
            weights[i] = Integer.parseInt(arrChar[i].trim());
        }

        System.out.println("Result: " + mapWordWeights(words, weights));
    }
}
