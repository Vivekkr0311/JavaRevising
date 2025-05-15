package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestUnequalAdjacentGroupsSubsequenceI_2900 {
    private static List<String> helper(String[] words, int[] groups, List<String> ans, int idx) {
        if (idx == words.length) {
            return ans;
        }

        List<String> take = new ArrayList<>();
        List<String> donTake = new ArrayList<>();
        if (idx == 0) {
            ans.add(words[idx]);
            take = helper(words, groups, ans, idx + 1);
        }

        if (idx > 0 && groups[idx - 1] != groups[idx]) {
            ans.add(words[idx]);
            take = helper(words, groups, ans, idx + 1);
        } else if (idx > 0 && groups[idx - 1] == groups[idx]) {
            donTake = helper(words, groups, ans, idx + 1);
        }

        take.addAll(donTake);
        return take;
    }

    private static List<String> getLongestSubsequence(String[] words, int[] groups) {
        return helper(words, groups, new ArrayList<>(), 0);
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

        System.out.println("Result: " + getLongestSubsequence(words, groups));
    }
}
