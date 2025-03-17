package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class JumpGameVII {
    private static boolean helper2(char[] charArray, int minJump, int maxJump, int travelIdx, int end) {
        // now this recursion, calls all possible jump condition
        if (travelIdx == end) {
            return true;
        }

        for (int jump = minJump; jump <= maxJump; jump++) {
            int nextJump = travelIdx + jump;

            if (nextJump <= end && charArray[nextJump] == '0' && helper2(charArray, minJump, maxJump, nextJump, end)) {
                return true;
            }
        }
        return false;
    }

    private static boolean helper(char[] charArray, int minJump, int maxJump, int travelIdx, int end) {
        // this approach is incorrect for the problem
        // this question solves when we have only two choices
        // either to make minJump or maxJump
        // but according to the question we can make any jump between minJump and maxJump
        // I kept this code because it helps me to understand the sub problem better.
        if (travelIdx == end) {
            return true;
        }

        boolean minJumpCondition = false;
        boolean maxJumpCondition = false;
        if (travelIdx + minJump <= end && charArray[travelIdx + minJump] != '1') {
            minJumpCondition = helper(charArray, minJump, maxJump, travelIdx + minJump, end);
        }

        if (travelIdx + maxJump <= end && charArray[travelIdx + maxJump] != '1') {
            maxJumpCondition = helper(charArray, minJump, maxJump, travelIdx + maxJump, end);
        }
        return minJumpCondition || maxJumpCondition;
    }

    private static boolean canReachUsingHelper1(String s, int minJump, int maxJump) {
        char[] charString = s.toCharArray();
        return helper(charString, minJump, maxJump, 0, charString.length - 1);
    }

    private static boolean canReachUsingHelper2(String s, int minJump, int maxJump) {
        char[] charString = s.toCharArray();
        return helper2(charString, minJump, maxJump, 0, charString.length - 1);
    }

    private static boolean canReachUsingSlidingWindowAndDP(String s, int minJump, int maxJump) {
        // this solution follows dynamic programming with sliding window
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        if (charArray[n - 1] == '1') return false;

        boolean[] dp = new boolean[n];
        dp[0] = true;
        int reachableCount = 0;

        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                reachableCount += dp[i - minJump] ? 1 : 0;
            }
            if (i > maxJump) {
                reachableCount -= dp[i - maxJump - 1] ? 1 : 0;
            }

            dp[i] = (charArray[i] == '0' && reachableCount > 0);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter binary string: ");
        String s = scanner.nextLine();

        System.out.println("Enter minJump: ");
        int minJump = scanner.nextInt();

        System.out.println("Enter maxJump: ");
        int maxJump = scanner.nextInt();

        System.out.println("Can we reach end ?: " + canReachUsingHelper1(s, minJump, maxJump));
        System.out.println("Can we reach end ?: " + canReachUsingHelper2(s, minJump, maxJump));
        System.out.println("Can we reach end ?: " + canReachUsingSlidingWindowAndDP(s, minJump, maxJump));
    }
}
