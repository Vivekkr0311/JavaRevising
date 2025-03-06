package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MaximumNumberOfVowelsInASubstringOfGivenLength_1456 {
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int ans = 0;
        int numberOfVowels = 0;
        char[] charArray = s.toCharArray();

        while (right < n) {
            if (isVowel(charArray[right])) {
                numberOfVowels += 1;
            }

            while (right - left + 1 > k) {
                if (isVowel(charArray[left])) {
                    numberOfVowels -= 1;
                }
                left++;
            }

            if (right - left + 1 == k) {
                ans = Math.max(ans, numberOfVowels);
            }
            right++;
        }
        return ans;
    }

    private static int numberOfVowels(char[] charArray, int start, int end) {
        int ans = 0;
        for (int i = start; i <= end; i++) {
            boolean condition = charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' ||
                    charArray[i] == 'o' || charArray[i] == 'u';
            if (condition) {
                ans += 1;
            }
        }
        return ans;
    }

    private static int maxVowelsBruteForce(String s, int k) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int ans = 0;

        for (int left = 0; left <= n - k; left++) {
            int numberOfVowels = numberOfVowels(charArray, left, left + k - 1);
            ans = Math.max(ans, numberOfVowels);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String s = scanner.nextLine();

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Maximum vowels in a substring of length " + k + " is " + maxVowelsBruteForce(s, k));
        System.out.println("Maximum vowels in a substring of length " + k + " is " + maxVowels(s, k));
    }
}