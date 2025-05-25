package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LongestPalindromeByConcatenatingTwoLetterWords_2131 {
    private static int longestPalindrome(String[] words) {
        int result = 0;
        boolean hasMiddlePalindrome = false;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : new HashSet<>(map.keySet())) {
            String checkString = "" + s.charAt(1) + s.charAt(0);
            int count = map.get(s);

            if (s.equals(checkString)) {
                result += (count / 2) * 4;
                if (count % 2 == 1) {
                    hasMiddlePalindrome = true;
                }
            } else if (map.containsKey(checkString) && map.get(checkString) > 0) {
                int pairCount = Math.min(count, map.get(checkString));
                result += pairCount * 4;
                map.put(checkString, 0);
                map.put(s, 0);
            }
        }

        if (hasMiddlePalindrome) {
            result += 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] words = new String[n];
        System.out.println("Enter each words: ");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        System.out.println("Result: " + longestPalindrome(words));
    }
}