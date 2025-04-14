package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.Scanner;

public class CountGoodTriplets_1534 {
    private static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i <= n - 3; i++) {
            for (int j = i + 1; j <= n - 2; j++) {
                int diff = Math.abs(arr[i] - arr[j]);

                if (diff <= a) {
                    for (int k = j + 1; k <= n - 1; k++) {
                        int diff2 = Math.abs(arr[j] - arr[k]);
                        int diff3 = Math.abs(arr[i] - arr[k]);
                        if (diff2 <= b && diff3 <= c) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter the values of a: ");
        int a = scanner.nextInt();

        System.out.println("Enter the values of b: ");
        int b = scanner.nextInt();

        System.out.println("Enter the values of c: ");
        int c = scanner.nextInt();

        System.out.println("Number of good triplets: " + countGoodTriplets(arr, a, b, c));
    }
}