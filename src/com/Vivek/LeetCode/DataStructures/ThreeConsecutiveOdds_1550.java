package com.Vivek.LeetCode.DataStructures;

import java.util.Scanner;

public class ThreeConsecutiveOdds_1550 {
    private static boolean isOdd(int n) {
        return (n & 1) != 0;
    }

    private static boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i + 2 < arr.length; i++) {
            if (isOdd(arr[i]) && isOdd(arr[i + 1]) && isOdd(arr[i + 2])) {
                return true;
            }
        }
        return false;
    }

    private static boolean threeConsecutiveOdds_(int[] arr) {
        int oddCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            oddCnt = ((arr[i] & 1) == 0) ? oddCnt + 1 : 0;

            if (oddCnt == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("There three consecutive odd number: " + threeConsecutiveOdds(arr));
        System.out.println("There three consecutive odd number: " + threeConsecutiveOdds_(arr));
    }
}
