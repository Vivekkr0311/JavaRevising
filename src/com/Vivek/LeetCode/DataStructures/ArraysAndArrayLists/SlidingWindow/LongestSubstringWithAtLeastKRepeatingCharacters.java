package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    private static boolean containsAtLeastK(String s, int k){
        HashMap<Character, Integer> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(Character ch : freq.keySet()){
            Integer currFreq = freq.get(ch);

            if(currFreq < k){
                return false;
            }
        }
        return true;
    }

    private static int longestSubstringBruteForce(String s, int k){
//        String ans = "";
//        int ansLength = ans.length();
        int ansLength = 0;
        int n = s.length();
        for(int i = 0; i + k <= n; i++){
            for(int j = i; j < n; j++){
                String subString = s.substring(i, j + 1);
                int currLength = j - i + 1;

                if(currLength >= k && currLength > ansLength && containsAtLeastK(subString, k)){
//                    ans = subString;
                    ansLength = currLength;
                }
            }
        }
        return ansLength;
    }

    private static int longestSubString(String s, int k){
        int maxLength = 0;
        int n = s.length();

        // Iterate over possible number of unique characters
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] charFreq = new int[26];
            int uniqueCount = 0;         // Number of unique characters in the window
            int countAtLeastK = 0;       // Number of characters appearing at least k times
            int left = 0;

            for (int right = 0; right < n; right++) {
                // Expand the window by adding the current character
                int rightIndex = s.charAt(right) - 'a';
                if (charFreq[rightIndex] == 0) {
                    uniqueCount++; // New unique character
                }
                charFreq[rightIndex]++;
                if (charFreq[rightIndex] == k) {
                    countAtLeastK++; // Character now appears at least k times
                }

                // Shrink the window if uniqueCount exceeds targetUnique
                while (uniqueCount > targetUnique) {
                    int leftIndex = s.charAt(left) - 'a';
                    if (charFreq[leftIndex] == k) {
                        countAtLeastK--; // Character no longer appears at least k times
                    }
                    charFreq[leftIndex]--;
                    if (charFreq[leftIndex] == 0) {
                        uniqueCount--; // One unique character removed
                    }
                    left++;
                }

                // Update maxLength if all unique characters meet the at-least-k condition
                if (uniqueCount == countAtLeastK) {
                    maxLength = Math.max(maxLength, right - left + 1);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

//        System.out.println("Longest substring with each frequency being at least " + k + " is: " + longestSubstringBruteForce(s, k));
        System.out.println("Longest substring with each frequency being at least " + k + " is: " + longestSubString(s, k));
    }
}
