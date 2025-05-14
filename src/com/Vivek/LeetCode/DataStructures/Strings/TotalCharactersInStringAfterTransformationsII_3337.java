package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TotalCharactersInStringAfterTransformationsII_3337 {
    private static final int MOD = 1000000007;

    private static int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] map = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map[s.charAt(i) - 'a']++;
        }

        for (int tr = 1; tr <= t; tr++) {
            int[] temp = new int[26];

            for (int i = 0; i < 26; i++) {
                int freq = map[i];
                int nextCharacters = nums.get(i);

                for (int currCh = 1; currCh <= freq; currCh++) {
                    for (int nextCh = 1; nextCh <= nextCharacters; nextCh++) {
                        temp[(i + nextCh) % 26] = (temp[(i + nextCh) % 26] + 1) % MOD;
                    }
                }
            }
            map = temp;
        }

        int result = 0;
        for (int i : map) {
            result += i;
        }
        return result;
    }

    private static int lengthAfterTransformations_(String s, int t, List<Integer> nums) {
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        for (int tr = 0; tr < t; tr++) {
            int[] temp = new int[26];

            for (int i = 0; i < 26; i++) {
                int freq = map[i];
                int nextCharacters = nums.get(i);

                if (freq > 0 && nextCharacters > 0) {
                    for (int j = 1; j <= nextCharacters; j++) {
                        int nextIdx = (i + j) % 26;
                        temp[nextIdx] = (int) ((temp[nextIdx] + (long) freq) % MOD);
                    }
                }
            }

            map = temp;
        }

        int result = 0;
        for (int val : map) {
            result = (result + val) % MOD;
        }

        return result;
    }

    // Matrix multiplication
    private static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < 26; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < 26; j++) {
                    result[i][j] = (int)((result[i][j] + 1L * A[i][k] * B[k][j]) % MOD);
                }
            }
        }
        return result;
    }

    // Fast matrix exponentiation
    private static int[][] matrixPower(int[][] matrix, long power) {
        int[][] result = new int[26][26];

        // Initialize result as identity matrix
        for (int i = 0; i < 26; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiply(result, matrix);
            }
            matrix = multiply(matrix, matrix);
            power >>= 1;
        }

        return result;
    }


    private static int lengthAfterTransformations__(String s, int t, List<Integer> nums) {
        int[][] transform = new int[26][26];

        // Build transformation matrix
        for (int i = 0; i < 26; i++) {
            int k = nums.get(i);
            for (int j = 1; j <= k; j++) {
                int next = (i + j) % 26;
                transform[i][next] = (transform[i][next] + 1) % MOD;
            }
        }

        // Frequency vector
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Fast matrix exponentiation: transform^t
        int[][] powered = matrixPower(transform, t);

        // Multiply freq vector with powered matrix
        int[] resultFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                resultFreq[j] = (int)((resultFreq[j] + 1L * freq[i] * powered[i][j]) % MOD);
            }
        }

        // Sum all frequencies
        int total = 0;
        for (int val : resultFreq) {
            total = (total + val) % MOD;
        }
        return total;
    }

    public static void main(String[] args) {
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2
//        2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Enter t: ");
        int t = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter each element of nums: ");
        for (int i = 0; i < 26; i++) {
            nums.add(scanner.nextInt());
        }

        System.out.println("Result: " + lengthAfterTransformations(s, t, nums));
        System.out.println("Result: " + lengthAfterTransformations_(s, t, nums));
        System.out.println("Result: " + lengthAfterTransformations__(s, t, nums));
    }
}
