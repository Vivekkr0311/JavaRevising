package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.*;

public class Finding3DigitEvenNumbers_2094 {
    private static boolean canWeForm(int[] map, int num) {
        while (num > 0) {
            int d = num % 10;
            if (map[d] == 0) {
                return false;
            }
            map[d]--;
            num = num / 10;
        }
        return true;
    }

    private static int[] findEvenNumbers(int[] digits) {
        int[] map = new int[10];
        List<Integer> result = new ArrayList<>();
        for (int i : digits) {
            map[i]++;
        }


        for (int num = 100; num < 999; num++) {
            int[] tempMap = new int[10];
            for (int i = 0; i < map.length; i++) {
                tempMap[i] = map[i];
            }

            if (((num & 1) == 0) && canWeForm(tempMap, num)) {
                result.add(num);
            }
        }

        int s = result.size();
        int[] res = new int[s];
        for (int i = 0; i < s; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        int[] digits = new int[n];

        System.out.println("Enter each element: ");
        for (int i = 0; i < digits.length; i++) {
            digits[i] = scanner.nextInt();
        }

        System.out.println("Result is: " + Arrays.toString(findEvenNumbers(digits)));
    }
}
