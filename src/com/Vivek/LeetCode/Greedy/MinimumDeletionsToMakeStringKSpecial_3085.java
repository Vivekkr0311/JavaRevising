package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumDeletionsToMakeStringKSpecial_3085 {
    private static int minimumDeletions(String word, int k) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int result = Integer.MAX_VALUE;
        int deletedTillNow = 0;

        for (int i = 0; i < 26; i++) {
            int minFreq = freq[i];
            int temp = deletedTillNow;

            for (int j = 25; j > i; j--) {
                if (freq[j] - freq[i] <= k)
                    break;

                temp += freq[j] - minFreq - k;
            }

            result = Math.min(result, temp);
            deletedTillNow += minFreq;
        }

        return result;
    }

    private static int minimumDeletionsOptimized(String word, int k) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        int deletion = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;
            int delete = 0;
            int curr = freq[i];
            for (int j = 0; j < 26; j++) {
                if (freq[j] == 0)
                    continue;
                if (i == j)
                    continue;
                if (freq[j] < curr) {
                    delete += freq[j];
                } else if (Math.abs(freq[j] - curr) > k) {
                    delete += Math.abs(freq[j] - curr) - k;
                }
            }
            deletion = Math.min(deletion, delete);
        }
        return deletion;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String input = scanner.nextLine();

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Minimum deletion required: " + minimumDeletions(input, k));
        System.out.println("Minimum deletion required: " + minimumDeletionsOptimized(input, k));
    }
}
