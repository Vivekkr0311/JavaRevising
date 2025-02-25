package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class LongestSubstringWithAtMostKDistinctCharacters_240 {
    private static boolean isAtMost(int[] freq, int k) {
        int count = 0;
        for (int c : freq) {
            if (c > 0) {
                count++;
            }
        }
        return count <= k;
    }

    private static int lengthOfLongestSubstringKDistinctBruteForce(String s, int k) {
        int ans = Integer.MIN_VALUE;
        char[] charArray = s.toCharArray();
        int[] freq = new int[26];

        for (int i = 0; i < charArray.length; i++) {
            for (int j = i; j < charArray.length; j++) {
                freq[charArray[j] - 'a']++;
                if (isAtMost(freq, k)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
            freq = new int[26];
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        int i = 0, j = 0, count = 0;
        char[] charArray = s.toCharArray();
        int[] freq = new int[26];

        while (j < n) {
            if (freq[charArray[j] - 'a'] == 0) {
                // new character
                count++;
            }

            freq[charArray[j] - 'a']++;

            while (count > k) {
                // shrink window if distinct count exceeds 'k'
                freq[charArray[i] - 'a']--;
                if (freq[charArray[i] - 'a'] == 0) {
                    // character removed completely
                    count--;
                }
                i++;
            }

            if (count <= k) {
                ans = Math.max(ans, j - i + 1);
            }

            j++;
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Enter the k: ");
        int k = scanner.nextInt();

        System.out.println("Substring of length " + lengthOfLongestSubstringKDistinctBruteForce(s, k) + " has the at most " + k + " unique characters.");
        System.out.println("Substring of length " + lengthOfLongestSubstringKDistinct(s, k) + " has the at most " + k + " unique characters.");
    }
}
