package com.Vivek.LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CountTheNumberOfPowerfulIntegers_2999 {
    private static final int MAX_DIGITS = 17;
    private static long[][] dp;

    private static boolean checkSubtract(String numStr, int numDigits, String suffix, int limit) {
        if (numDigits < suffix.length()) return false;

        String suffixOfNum = numStr.substring(numDigits - suffix.length());
        boolean subtract = Long.parseLong(suffixOfNum) < Long.parseLong(suffix);

        if (subtract) {
            for (int i = 0; i < numDigits - suffix.length(); ++i) {
                if ((numStr.charAt(i) - '0') > limit) {
                    subtract = false;
                    break;
                }
            }
        }
        return subtract;
    }

    private static long countValidNumbers(String numberStr, int idx, int maxDigits,
                                   boolean isTight, int limit, String suffix) {
        if (idx == maxDigits) return 1;
        if (dp[idx][isTight ? 1 : 0] != -1) return dp[idx][isTight ? 1 : 0];

        int low, high;
        int suffixLen = suffix.length();

        if (idx >= maxDigits - suffixLen) {
            int suffixIdx = idx - (maxDigits - suffixLen);
            low = high = suffix.charAt(suffixIdx) - '0';
        } else {
            high = isTight ? Math.min(limit, numberStr.charAt(idx) - '0') : limit;
            low = 0;
        }

        long total = 0;
        for (int digit = low; digit <= high; ++digit) {
            boolean newTight = isTight && (digit == numberStr.charAt(idx) - '0');
            total += countValidNumbers(numberStr, idx + 1, maxDigits, newTight, limit, suffix);
        }

        dp[idx][isTight ? 1 : 0] = total;
        return total;
    }

    private static long solveUpTo(String numStr, int numDigits, int limit, String suffix) {
        dp = new long[MAX_DIGITS][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        long result = countValidNumbers(numStr, 0, numDigits, true, limit, suffix);
        if (checkSubtract(numStr, numDigits, suffix, limit)) {
            result--;
        }
        return result;
    }

    private static long numberOfPowerfulInt(long start, long finish, int limit, String suffix) {
        long suffixVal = Long.parseLong(suffix);
        String finishStr = Long.toString(finish);
        String startStr = Long.toString(start - 1);

        int finishDigits = finishStr.length();
        int startDigits = startStr.length();

        long uptoFinish = (finish >= suffixVal) ? solveUpTo(finishStr, finishDigits, limit, suffix) : 0;
        long uptoStart = (suffixVal < start) ? solveUpTo(startStr, startDigits, limit, suffix) : 0;

        return uptoFinish - uptoStart;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the start: ");
        long start = scanner.nextLong();

        System.out.println("Enter the finish: ");
        long finish = scanner.nextLong();

        System.out.println("Enter the limit: ");
        int limit = scanner.nextInt();

        System.out.println("Enter the suffix: ");
        String suffix = scanner.next();

        System.out.println("Number of powerful integers: " + numberOfPowerfulInt(start, finish, limit, suffix));
    }
}
