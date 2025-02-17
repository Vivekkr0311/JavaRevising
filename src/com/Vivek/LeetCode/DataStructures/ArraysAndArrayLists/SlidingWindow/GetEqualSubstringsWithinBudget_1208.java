package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class GetEqualSubstringsWithinBudget_1208 {
    private static int equalSubstringBruteForce(String s, String t, int maxCost) {
        int ans = Integer.MIN_VALUE;
        int n = s.length();
        int i = 0;
        int j = 0;
        int currCost = 0;
        while (i < n && j < n) {
            if (s.charAt(j) != t.charAt(j)) {
                currCost += Math.abs(s.charAt(j) - t.charAt(j));
            }

            if (currCost <= maxCost) {
                ans = Math.max(ans, j - i + 1);
            }

            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            j++;
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    private static int equalSubstringSlidingWindow(String s, String t, int maxCost) {
        int ans = 0;
        int n = s.length();
        int i = 0;
        int j = 0;
        int currCost = 0;
        while (i < n && j < n) {
            int cost = Math.abs(s.charAt(j) - t.charAt(j));
            currCost += cost;

            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = scanner.nextLine();

        System.out.println("Enter t: ");
        String t = scanner.nextLine();

        System.out.println("Enter maxCost: ");
        int maxCost = scanner.nextInt();

        System.out.println("Cost to make " + s + " to " + t + " is " + equalSubstringBruteForce(s, t, maxCost));
    }
}
