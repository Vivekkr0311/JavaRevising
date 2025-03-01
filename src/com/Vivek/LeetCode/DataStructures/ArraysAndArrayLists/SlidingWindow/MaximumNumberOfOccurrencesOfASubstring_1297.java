package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MaximumNumberOfOccurrencesOfASubstring_1297 {
    private static int countUniqueCharacters(char[] charString, int left, int right) {
        HashSet<Character> set = new HashSet<>();
        for (int idx = left; idx <= right; idx++) {
            char ch = charString[idx];
            if (!set.contains(ch)) {
                set.add(ch);
            }
        }

        return set.size();
    }

    private static int maxFreqBruteForce(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;
        HashMap<String, Integer> freqMap = new HashMap<>();

        char[] charString = s.toCharArray();

        for (int left = 0; left < charString.length; left++) {
            for (int right = left; right < charString.length; right++) {
                int numberOfUniqueCharacters = countUniqueCharacters(charString, left, right);
                int currSubStringLength = right - left + 1;
                if (numberOfUniqueCharacters <= maxLetters && currSubStringLength >= minSize && currSubStringLength <= maxSize) {
                    String subString = s.substring(left, right + 1);
                    freqMap.put(subString, freqMap.getOrDefault(subString, 0) + 1);
                }
            }
        }

        for (Integer val : freqMap.values()) {
            ans =  Math.max(ans, val);
        }
        return ans;
    }

    private static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Enter maxLetters: ");
        int maxLetters = scanner.nextInt();

        System.out.println("Enter minSize: ");
        int minSize = scanner.nextInt();

        System.out.println("Enter maxSize: ");
        int maxSize = scanner.nextInt();

        System.out.println("Ans: " + maxFreq(s, maxLetters, minSize, maxSize));
        System.out.println("Ans: " + maxFreqBruteForce(s, maxLetters, minSize, maxSize));
    }
}