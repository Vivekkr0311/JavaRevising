package com.Vivek.ArraysAndArrayLists.SlidingWindow;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter s1: ");
        String s1 = scanner.nextLine();

        System.out.println("Enter s2: ");
        String s2 = scanner.nextLine();

        System.out.println(s2 + " contains permutation of " + s2 + ": " + checkInclusion(s1, s2));
    }
}
