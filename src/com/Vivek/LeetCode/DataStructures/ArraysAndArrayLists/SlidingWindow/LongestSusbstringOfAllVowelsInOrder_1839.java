package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSusbstringOfAllVowelsInOrder_1839 {
    private static int longestBeautifulSubstring(String word) {
        char[] charArray = word.toCharArray();
        int n = charArray.length;
        int left = 0;
        int right = 0;
        int[] map = new int[5];
        int ansLength = 0;

        // a -> 0
        // e -> 1
        // i -> 2
        // o -> 3
        // u -> 4

        while (right < n) {
            char ch = charArray[right];
            boolean resetWindow = false;

            switch (ch) {
                case 'a':
                    if (map[1] == 0 && map[2] == 0 && map[3] == 0 && map[4] == 0) {
                        map[0]++;
                    } else {
                        resetWindow = true;
                    }
                    break;
                case 'e':
                    if (map[0] > 0 && map[2] == 0 && map[3] == 0 && map[4] == 0) {
                        map[1]++;
                    } else {
                        resetWindow = true;
                    }
                    break;
                case 'i':
                    if (map[0] > 0 && map[1] > 0 && map[3] == 0 && map[4] == 0) {
                        map[2]++;
                    } else {
                        resetWindow = true;
                    }
                    break;
                case 'o':
                    if (map[0] > 0 && map[1] > 0 && map[2] > 0 && map[4] == 0) {
                        map[3]++;
                    } else {
                        resetWindow = true;
                    }
                    break;
                case 'u':
                    if (map[0] > 0 && map[1] > 0 && map[2] > 0 && map[3] > 0) {
                        map[4]++;
                    } else {
                        resetWindow = true;
                    }
                    break;
                default:
                    resetWindow = true;
            }

            if (resetWindow) {
                map = new int[5];
                left = right + 1;
            } else {
                if (map[0] > 0 && map[1] > 0 && map[2] > 0 && map[3] > 0 && map[4] > 0) {
                    ansLength = Math.max(ansLength, right - left + 1);
                }
            }

            right++;
        }
        return ansLength;
    }

    private static int longestBeautifulSubstring2(String word) {
        Set<Character> set = new HashSet<>();
        char[] charArray = word.toCharArray();
        int n = charArray.length;
        int left = 0;
        int right = 0;
        int ansLength = 0;

        while (right < n) {
            if (right > 0 && charArray[right - 1] > charArray[right]) {
                left = right;
                set.clear();
            }

            set.add(charArray[right]);
            if (set.size() == 5) {
                ansLength = Math.max(ansLength, right - left + 1);
            }

            right++;
        }
        return ansLength;
    }

    private static int longestBeautifulSubstring3(String word) {
        int n = word.length();
        int left = 0, right = 0, ansLength = 0;
        int count = 0; // To count distinct vowels in order

        while (right < n) {
            if (right > 0 && word.charAt(right) < word.charAt(right - 1)) {
                // Reset the window if the sequence is broken
                count = 0;
                left = right;
            }

            if (right == left || word.charAt(right) != word.charAt(right - 1)) {
                count++; // Count unique vowels
            }

            if (count == 5) { // Found all vowels in order
                ansLength = Math.max(ansLength, right - left + 1);
            }

            right++;
        }

        return ansLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String word = scanner.nextLine();

        System.out.println("Length of beautiful subtring is: " + longestBeautifulSubstring(word));
        System.out.println("Length of beautiful subtring is: " + longestBeautifulSubstring2(word));
        System.out.println("Length of beautiful subtring is: " + longestBeautifulSubstring3(word));
    }
}
