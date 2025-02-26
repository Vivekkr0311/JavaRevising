package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class PermutationInString {
    private static boolean checkExist(int[] map) {
        for (int i : map) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] map = new int[26];

        for (int i = 0; i < m; i++) {
            map[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        while (right < n) {
            map[s2.charAt(right) - 'a']--;

            if (right - left + 1 == m) {
                if (checkExist(map)) {
                    return true;
                }

                map[s2.charAt(left) - 'a']++;
                left++;
            }

            right++;
        }
        return false;
    }

    private static boolean checkAnagram(int[] map, char[] charArrayS2, int start, int end) {
        int[] tempMap = new int[26];
        System.arraycopy(map, 0, tempMap, 0, 26); // Copy map to tempMap

        for (int i = start; i < end; i++) {
            tempMap[charArrayS2[i] - 'a']--;
        }

        for (int count : tempMap) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkInclusionBruteForce(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();
        if (m > n) return false;

        int[] map = new int[26];
        char[] charArrayS2 = s2.toCharArray();

        // Count frequency of characters in s1
        for (char c : s1.toCharArray()) {
            map[c - 'a']++;
        }

        // Check every substring of length m in s2
        for (int i = 0; i <= n - m; i++) {
            if (checkAnagram(map, charArrayS2, i, i + m)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter s1: ");
        String s1 = scanner.nextLine();

        System.out.println("Enter s2: ");
        String s2 = scanner.nextLine();

        System.out.println(s2 + " contains permutation of " + s1 + ": " + checkInclusion(s1, s2));
        System.out.println(s2 + " contains permutation of " + s1 + ": " + checkInclusionBruteForce(s1, s2));
    }
}
