package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class DIStringMatch_942 {
    private static int[] diStringMatch(String s) {
        int start = 0;
        int end = s.length();
        char[] str = s.toCharArray();
        int[] result = new int[end + 1];
        int idx = 0;
        while (start <= end) {
            if (idx == str.length) {
                break;
            }
            if (str[idx] == 'I') {
                result[idx] = start++;
            } else if (str[idx] == 'D') {
                result[idx] = end--;
            }
            idx++;
        }

        result[idx] = end;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Result: " + Arrays.toString(diStringMatch(s)));
    }
}