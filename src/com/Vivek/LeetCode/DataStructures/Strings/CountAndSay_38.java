package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Scanner;

public class CountAndSay_38 {
    private static int timesOccurred(char ch, String str, int start, int end) {
        int cnt = 0;
        for (int i = start; i < end; i++) {
            if (str.charAt(i) == ch) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    private static String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();

        int timesOccurred;
        for (int i = 0; i < prev.length(); i += timesOccurred) {
            timesOccurred = timesOccurred(prev.charAt(i), prev, i, prev.length());
            result.append(timesOccurred);
            result.append(prev.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        System.out.println("Count and Say sequence: " + countAndSay(n));
    }
}