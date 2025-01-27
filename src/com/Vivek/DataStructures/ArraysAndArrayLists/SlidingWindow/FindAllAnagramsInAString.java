package com.Vivek.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllAnagramsInAString {
    private static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] map = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }

        for (int i : map) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> findAnagramsSlidingWindowButSlow(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i + m <= n; i++) {
            String s1 = s.substring(i, i + m);
            if (areAnagrams(s1, p)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static boolean isMapEmpty(int[] char_counts){
        for(int i : char_counts){
            if( i != 0){
                return false;
            }
        }
        return true;
    }

    private static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();

        int[] char_counts = new int[26];
        for (int i = 0; i < m; i++) {
            char_counts[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;

        while (right < n) {
            char_counts[s.charAt(right) - 'a']--;

            if(right - left + 1 == m){
                if(isMapEmpty(char_counts)){
                    ans.add(left);
                }

                char_counts[s.charAt(left) - 'a']++;
                left++;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = scanner.nextLine();

        System.out.println("Enter your pattern: ");
        String p = scanner.nextLine();

        System.out.println("Anagrams present in indices: " + findAnagramsSlidingWindowButSlow(s, p));
        System.out.println("Anagrams present in indices: " + findAnagrams(s, p));
    }
}