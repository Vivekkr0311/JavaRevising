package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class ReplaceTheSubstringForBalancedString_1234 {
    private static int balancedString(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int target = n / 4;
        char[] charArray = s.toCharArray();
        int ansLength = n;
        int[] chars = new int[26];

        for (int k = 0; k < n; k++) {
            chars[charArray[k] - 'A']++;
        }

        while (j < n) {
            chars[charArray[j] - 'A']--;

            while (i < n &&
                    chars['Q' - 'A'] <= target &&
                    chars['W' - 'A'] <= target &&
                    chars['R' - 'A'] <= target &&
                    chars['E' - 'A'] <= target) {

                chars[charArray[i] - 'A']++;

                ansLength = Math.min(ansLength, j - i + 1);
                i++;
            }
            j++;
        }
        return ansLength == n ? 0 : ansLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Length of substring to replace: " + balancedString(s));
    }
}