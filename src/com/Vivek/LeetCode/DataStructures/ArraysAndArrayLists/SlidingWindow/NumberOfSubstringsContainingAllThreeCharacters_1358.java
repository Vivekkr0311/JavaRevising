package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class NumberOfSubstringsContainingAllThreeCharacters_1358 {
    private static int numberOfSubstringsOptimized(String s) {
        int[] last_seen = {-1, -1, -1};
        int ans = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            if (ch >= 'a' && ch <= 'c') {
                last_seen[ch - 'a'] = i;
            }

            if (last_seen[0] != -1 && last_seen[1] != -1 && last_seen[2] != -1) {
                ans += 1 + Math.min(last_seen[0], Math.min(last_seen[1], last_seen[2]));
            }
        }

        return ans;
    }

    private static int numberOfSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        int[] map = new int[3];

        while (right < n) {
            char ch = charArray[right];
            if (ch == 'a' || ch == 'b' || ch == 'c') {
                map[charArray[right] - 'a']++;
            }

            while (map[0] >= 1 && map[1] >= 1 && map[2] >= 1) {
                ans += n - right;
                map[charArray[left] - 'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }


    private static int numberOfSubstringsBruteForce(String s) {
        int ans = 0;
        int n = s.length();
        char[] charArray = s.toCharArray();

        for (int left = 0; left < n; left++) {
            int[] map = new int[26];
            for (int right = left; right < n; right++) {
                // substring can be found in this inner loop only
                map[charArray[right] - 'a']++;

                if (map[0] >= 1 && map[1] >= 1 && map[2] >= 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Number of substring containing all three characters a/b/c are: " + numberOfSubstringsBruteForce(s));
        System.out.println("Number of substring containing all three characters a/b/c are: " + numberOfSubstrings(s));
        System.out.println("Number of substring containing all three characters a/b/c are: " + numberOfSubstringsOptimized(s));
    }
}