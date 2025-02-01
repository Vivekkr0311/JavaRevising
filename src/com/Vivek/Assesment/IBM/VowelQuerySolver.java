package com.Vivek.Assesment.IBM;

import java.util.ArrayList;
import java.util.List;

public class VowelQuerySolver {
 /**
  * Given a string array `strArr` containing `n` elements composed of lowercase English letters, and `q` queries, each in the format `l-r`, the task is to determine how many strings starting at index `l` and ending at index `r` have vowels as both the first and last character. Vowels are defined as {a, e, i, o, u}.
  * Example:
  * strArr = ["aba", "bcb", "ece", "aa", "e"]
  * queries = ["1-3", "2-5", "2-2"]
  *
  * - For the interval `1-3` (inclusive), the strings are ["aba", "bcb", "ece"]. "aba" and "ece" both start and end with a vowel. Thus, the result is 2.
  * - For the interval `2-5`, the strings are ["bcb", "ece", "aa", "e"]. "ece", "aa", and "e" start and end with vowels, so the result is 3.
  * - For the interval `2-2`, the only string is "bcb", which does not satisfy the condition, so the result is 0.
  *
  * The function `hasVowels` should return an array of integers representing the result for each query.
  * Function Signature:
  * int[] hasVowels(String[] strArr, String[] queries)
  * Constraints:
  * - 1 ≤ n, q ≤ 10^5
  * - 1 ≤ size of strArr[i] ≤ 10
*/

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static List<Integer> hasVowels(String[] strArr, String[] queries) {
        int n = strArr.length;
        int[] prefixVowelCounts = new int[n + 1]; // Prefix sum array

        // Compute prefix sums for strings starting and ending with vowels
        for (int i = 0; i < n; i++) {
            String s = strArr[i];
            if (!s.isEmpty() && isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))) {
                prefixVowelCounts[i + 1] = prefixVowelCounts[i] + 1;
            } else {
                prefixVowelCounts[i + 1] = prefixVowelCounts[i];
            }
        }

        List<Integer> result = new ArrayList<>();

        // Process each query
        for (String query : queries) {
            String[] parts = query.split("-");
            int l = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[1]);

            // Compute result using prefix sums (convert 1-based to 0-based indexing)
            int count = prefixVowelCounts[r] - prefixVowelCounts[l - 1];
            result.add(count);
        }

        return result;
    }


    public static void main(String[] args) {
        String[] strArr = {"aab", "a", "bcd", "awe", "bbbbbu"};
        String[] queries = {"1-3", "2-5", "2-2"};

        List<Integer> result = hasVowels(strArr, queries);
        for (int count : result) {
            System.out.println(count);
        }
    }
}
