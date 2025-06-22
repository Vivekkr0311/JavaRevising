package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class DivideAStringIntoGroupsOfSizeK_2138 {
    private static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = 0;
        if ((n % k) == 0) {
            size = n / k;
        } else {
            size = (n / k) + 1;
        }
        String[] result = new String[size];

        int idx = 0;
        for (int i = 0; i < n; i += k) {
            if ((i + k > n)) {
                StringBuilder sb = new StringBuilder();
                String subStr = s.substring(i, n);
                sb.append(subStr);
                while (sb.length() < k) {
                    sb.append(fill);
                }

                result[idx] = sb.toString();
                break;
            }
            String subStr = s.substring(i, i + k);
            result[idx++] = subStr;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = scanner.nextLine();

        System.out.println("Enter the k: ");
        int k = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the fill: ");
        char fill = scanner.nextLine().charAt(0);

        System.out.println("Divided the string: " + Arrays.toString(divideString(str, k, fill)));
    }
}
