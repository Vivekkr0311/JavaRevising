package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    private static int lengthOfLongestSubstring(String input) {
        int left = 0;
        int right = 0;
        int n = input.length();

        int length = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            if (set.contains(input.charAt(right))) {
                set.remove(input.charAt(left));
                left++;
            } else {
                set.add(input.charAt(right));
                right++;
                length = Math.max(length, set.size());
            }
        }
        return length;
    }

    private static int lengthOfLongestSubstringBruteForce(String s) {
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> seen = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                if (seen.contains(s.charAt(j))) {
                    break;
                }

                seen.add(s.charAt(j));
                length = Math.max(length, j - i + 1);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Length of the longest substring without repeating characters is: " + lengthOfLongestSubstringBruteForce(s));
        System.out.println("Length of the longest substring without repeating characters is: " + lengthOfLongestSubstring(s));
    }
}
