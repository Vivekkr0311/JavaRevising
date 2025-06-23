package com.Vivek.LeetCode.Maths;

import java.util.Scanner;

public class SumOfKMirrorNumbers_2081 {
    private static String convertBaseK(long n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    private static boolean palindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    private static long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            for (int half = (int)Math.pow(10, len - 1); count < n && half < (int)Math.pow(10, len); half++) {
                String s = String.valueOf(half);
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(sb.length() - 1); // Remove last digit for odd
                long pal = Long.parseLong(s + sb.reverse());

                if (palindrome(convertBaseK(pal, k))) {
                    sum += pal;
                    count++;
                }
            }

            for (int half = (int)Math.pow(10, len - 1); count < n && half < (int)Math.pow(10, len); half++) {
                String s = String.valueOf(half);
                StringBuilder sb = new StringBuilder(s);
                long pal = Long.parseLong(s + sb.reverse());

                if (palindrome(convertBaseK(pal, k))) {
                    sum += pal;
                    count++;
                }
            }

            len++;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println("Sum " + kMirror(k, n));
    }
}