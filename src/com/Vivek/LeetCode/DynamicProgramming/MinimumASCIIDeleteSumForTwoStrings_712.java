package com.Vivek.LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumASCIIDeleteSumForTwoStrings_712 {
    private static int recursionHelper(String s1, String s2, int i, int j) {
        if (i < 0 && j < 0) {
            return 0;
        }

        if (i < 0) {
            int sum = 0;
            while (j >= 0) {
                sum += s2.charAt(j--);
            }
            return sum;
        }

        if (j < 0) {
            int sum = 0;
            while (i >= 0) {
                sum += s1.charAt(i--);
            }
            return sum;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return recursionHelper(s1, s2, i - 1, j - 1);
        } else {
            return Math.min(
              s1.charAt(i) + recursionHelper(s1, s2,i - 1, j),
              s2.charAt(j) + recursionHelper(s1, s2, i, j-1)
            );
        }
    }

    private static int minimumDeletionSumRecursion(String s1, String s2) {
        return recursionHelper(s1, s2,s1.length() - 1, s2.length() - 1);
    }

    private static int[][] dp;
    private static int dpSolutionFromRecursion(String s1, String s2, int i, int j) {
        if( i < 0 && j < 0) {
            return 0;
        }

        if (i < 0) {
            int sum = 0;
            while (j >= 0) {
                sum += s2.charAt(j--);
            }
            return sum;
        }

        if(j < 0) {
            int sum = 0;
            while (i >= 0) {
                sum += s1.charAt(i--);
            }
            return sum;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = dpSolutionFromRecursion(s1, s2, i - 1, j - 1);
        } else {
            dp[i][j] = Math.min(
                    s1.charAt(i) + dpSolutionFromRecursion(s1, s2, i - 1, j),
                    s2.charAt(j) + dpSolutionFromRecursion(s1, s2, i, j- 1)
            );
        }
        return dp[i][j];
    }

    private static int dpMinimumDeleteSumFromRecursion(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dpSolutionFromRecursion(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    private static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j] + s1.charAt(i - 1),
                            dp[i][j - 1] + s2.charAt(j - 1)
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.println("Enter the second string: ");
        String str2 = scanner.nextLine();

        System.out.println("Minimum sum to delete: " + minimumDeleteSum(str1, str2));
        System.out.println("Minimum sum to delete: " + minimumDeletionSumRecursion(str1, str2));
        System.out.println("Minimum sum to delete: " + dpMinimumDeleteSumFromRecursion(str1, str2));
    }
}
