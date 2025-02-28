package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class LongestRepeatingCharacterReplacement_424 {
    private static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;

            if (freq[s.charAt(right) - 'A'] > maxFreq) {
                maxFreq = freq[s.charAt(right) - 'A'];
            }

            int windowLength = right - left + 1;

            if (windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            windowLength = right - left + 1;
            if (windowLength > maxWindow) {
                maxWindow = windowLength;
            }
        }

        return maxWindow;
    }

    private static int characterReplacementSlidingWindow(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        int r = 0;
        int l = 0;
        int maxFreq = 0;
        char[] charArray = s.toCharArray();
        int[] freq = new int[26];

        while (r < n) {
            freq[charArray[r] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[charArray[r] - 'A']);
            int currLength = r - l + 1;
            while (currLength - maxFreq > k) {
                freq[charArray[l] - 'A']--;
                l++;

                maxFreq = 0;
                for (int i = 0; i < freq.length; i++) {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }

                currLength = r - l + 1;
            }

            if (currLength - maxFreq <= k) {
                maxLen = Math.max(maxLen, currLength);
            }
            r++;
        }

        return maxLen;
    }

    private static int characterReplacementSlidingWindow2(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        int r = 0;
        int l = 0;
        int maxFreq = 0;
        char[] charArray = s.toCharArray();
        int[] freq = new int[26];

        while (r < n) {
            freq[charArray[r] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[charArray[r] - 'A']);
            int currLength = r - l + 1;
            if (currLength - maxFreq > k) {
                freq[charArray[l] - 'A']--;
                l++;
            }

            if (currLength - maxFreq <= k) {
                maxLen = Math.max(maxLen, currLength);
            }
            r++;
        }

        return maxLen;
    }

    private static int characterReplacementBruteForce(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int[] freq = new int[26];
                int maxFreq = 0;

                for (int i = left; i <= right; i++) {
                    freq[s.charAt(i) - 'A']++;
                    maxFreq = Math.max(maxFreq, freq[s.charAt(i) - 'A']);
                }

                int len = right - left + 1;
                int requiredReplacement = len - maxFreq;

                if (requiredReplacement <= k) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Enter the k: ");
        int k = scanner.nextInt();

        System.out.println("Length of longest repeating string by replacing " + k + " character is: " + characterReplacement(s, k));
        System.out.println("Length of longest repeating string by replacing " + k + " character is: " + characterReplacementBruteForce(s, k));
        System.out.println("Length of longest repeating string by replacing " + k + " character is: " + characterReplacementSlidingWindow(s, k));
        System.out.println("Length of longest repeating string by replacing " + k + " character is: " + characterReplacementSlidingWindow2(s, k));
    }
}
