package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class SwapForLongestRepeatedCharacterSubstring_1156 {
    /*
  Approach: Sliding Window with Character Frequency Count

  1. Use a hash table or an array (cnt[]) to count the occurrences of each character in the string.
  2. Initialize a pointer 'i' at index 0.
  3. Set another pointer 'j' to 'i' and move 'j' to the right until we find a different character.
     - This forms a substring text[i...j-1] of length 'l' where all characters are the same.
  4. Skip the character at 'j' and move another pointer 'k' to the right until we find a character different from text[i].
     - This forms another substring text[j+1...k-1] of length 'r' with the same character.
  5. Compute the maximum length of a single-character repeated substring after at most one swap:
     - maxLength = min(l + r + 1, cnt[text[i]]), ensuring we don't exceed the total occurrences of that character.
  6. Move 'i' to 'j' and repeat for the next segment.

  Time Complexity: O(N), since we traverse the string with two pointers.
  Space Complexity: O(1), as we store character frequencies in a fixed-size array (26 characters).
*/

    private static int maxRepOpt1(String text) {
        int[] map = new int[26];
        int n = text.length();
        for (int i = 0; i < n; i++) {
            map[text.charAt(i) - 'a']++;
        }

        int length = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && text.charAt(j) == text.charAt(i)) {
                j++;
            }

            int l = j - i;
            int k = j + 1;
            while (k < n && text.charAt(k) == text.charAt(i)) {
                k++;
            }

            int r = k - j - 1;
            length = Math.max(length, Math.min(r + l + 1, map[text.charAt(i) - 'a']));
            i = j;
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String text = scanner.nextLine();

        System.out.println("Longest repeated character with one character swap is: " + maxRepOpt1(text));
    }
}
