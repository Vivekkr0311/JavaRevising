package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;
// https://leetcode.com/problems/longest-turbulent-subarray/description/?envType=problem-list-v2&envId=sliding-window

import java.util.Scanner;

public class LongestTurbulentSubarray_978 {
//    private static boolean isTurbulent2(int[] arr, int i, int j) {
//
//    }

    public int maxTurbulenceSizeSlidingWindow(int[] arr) {
        int maxSize = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int n = arr.length;

        while (j < n) {
            boolean isTurbulent = isTurbulent(arr, i, j);

            if (isTurbulent) {
                maxSize = Math.max(maxSize, j - i + 1);
            } else {
                i++;
            }
            j++;
        }
        return maxSize;
    }

    private static int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        int maxSize = 1;
        while (j < n) {
            if (arr[j - 1] == arr[j]) {
                maxSize = Math.max(maxSize, 1);
                i = j;
            } else if (j == n - 1) {
                maxSize = Math.max(maxSize, j - i + 1);
            } else {
                boolean firstTwoGreater = arr[j - 1] > arr[j];
                boolean secondTwoLesser = j + 1 < n ? arr[j] < arr[j + 1] : true;

                boolean firstTwoSmaller = arr[j - 1] < arr[j];
                boolean secondTwoGreater = j + 1 < n ? arr[j] > arr[j + 1] : true;

                if (firstTwoGreater && secondTwoLesser || firstTwoSmaller && secondTwoGreater) {
                    maxSize = Math.max(maxSize, j - i + 1);
                } else {
                    maxSize = Math.max(maxSize, j - i + 1);
                    i = j;
                }
            }

            j++;
        }
        return maxSize;
    }

    private static boolean isTurbulent(int[] arr, int i, int j) {
        if (i == j) {
            return true;
        }

        boolean patternA = true;
        boolean patternB = true;

        for (int k = i; k < j; k++) {
            if ((k - i) % 2 == 0) {
                if (!(arr[k] < arr[k + 1])) {
                    patternA = false;
                }
                if (!(arr[k] > arr[k + 1])) {
                    patternB = false;
                }
            } else {
                if (!(arr[k] > arr[k + 1])) {
                    patternA = false;
                }
                if (!(arr[k] < arr[k + 1])) {
                    patternB = false;
                }
            }

            if (!patternA && !patternB) {
                return false;
            }
        }

        return patternA || patternB;
    }

    private static int maxTurbulenceSizeBruteForce(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int currLength = 1;
            for (int j = i + 1; j < arr.length; j++) {
                boolean isTurbulent = isTurbulent(arr, i, j);

                if (isTurbulent) {
                    currLength = j - i + 1;
                } else {
                    break;
                }
            }

            ans = Math.max(ans, currLength);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Length of longest turbulent subarray is: " + maxTurbulenceSizeBruteForce(arr));
        System.out.println("Length of longest turbulent subarray is: " + maxTurbulenceSize(arr));
    }
}
