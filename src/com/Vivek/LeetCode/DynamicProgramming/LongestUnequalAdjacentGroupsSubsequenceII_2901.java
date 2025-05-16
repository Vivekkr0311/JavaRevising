package com.Vivek.LeetCode.DynamicProgramming;

import java.util.*;

public class LongestUnequalAdjacentGroupsSubsequenceII_2901 {
    private static boolean hammingDistanceOne(String s1, String s2) {
        int diff = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }

        return diff == 1;
    }

    private static List<String> getLongestSubsequence_(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n]; // dp[i] = longest subsequence ending at i
        int[] parent = new int[n]; // backtrack path
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int longestSub = 1;
        int longestSubIdx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j]
                        && words[i].length() == words[j].length()
                        && hammingDistanceOne(words[i], words[j])) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;

                        if (dp[i] > longestSub) {
                            longestSub = dp[i];
                            longestSubIdx = i;
                        }
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        while (longestSubIdx != -1) {
            result.add(words[longestSubIdx]);
            longestSubIdx = parent[longestSubIdx];
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of words array: ");
        int m = scanner.nextInt();
        scanner.nextLine();

        String[] words = new String[m];
        System.out.println("Enter each words: ");
        for (int i = 0; i < m; i++) {
            words[i] = scanner.nextLine();
        }

        System.out.println("Enter n for groups: ");
        int n = scanner.nextInt();
        int[] groups = new int[n];

        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            groups[i] = scanner.nextInt();
        }

        System.out.println("Result: " + getLongestSubsequence_(words, groups));
    }
}
