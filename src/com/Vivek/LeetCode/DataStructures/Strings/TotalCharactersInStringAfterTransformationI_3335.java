package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Scanner;

public class TotalCharactersInStringAfterTransformationI_3335 {
    private static final int MOD = 1000000007;

    private static int lengthAfterTransformations(String s, int t) {
        int[] mp = new int[26];

        for (char ch : s.toCharArray()) {
            mp[ch - 'a']++;
        }

        for (int count = 1; count <= t; count++) {
            int[] temp = new int[26];

            for (int i = 0; i < 26; i++) {
                char ch = (char) (i + 'a');
                int freq = mp[i];

                if (ch != 'z') {
                    temp[(ch + 1) - 'a'] = (temp[(ch + 1) - 'a'] + freq) % MOD;
                } else {
                    temp['a' - 'a'] = (temp['a' - 'a'] + freq) % MOD;
                    temp['b' - 'a'] = (temp['b' - 'a'] + freq) % MOD;
                }
            }

            mp = temp;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + mp[i]) % MOD;
        }

        return result;
    }

    private static int lengthAfterTransformationsBruteForce(String s, int t) {
        int n = s.length();
        StringBuilder sb;
        for (int t1 = 1; t1 <= t; t1++) {
            sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'z') {
                    sb.append("ab");
                } else {
                    sb.append((char) (s.charAt(i) + 1));
                }
            }
            s = sb.toString();
            n = s.length();
        }

        return n % MOD;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Enter t: ");
        int t = scanner.nextInt();

        System.out.println("Answer: " + lengthAfterTransformations(s, t));
        System.out.println("Answer: " + lengthAfterTransformationsBruteForce(s, t));
    }
}