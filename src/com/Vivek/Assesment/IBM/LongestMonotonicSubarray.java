package com.Vivek.Assesment.IBM;

public class LongestMonotonicSubarray {
    /**
     * A bitonic sequence is a sequence of numbers that first increases (non-decreasing) and then decreases (non-increasing).
     * Given an array of integers, find the length of the longest subarray that is bitonic in nature.
     * Example
     * arr = [10, 8, 9, 15, 12, 6, 7]
     * [8, 9, 15, 12, 6] is the longest bitonic subarray. Return its length, 5.
     * Function Description
     * Complete the function longestBitonicSubarray in the editor with the following parameter(s):
     * int arr[n]: an array of integers
     * Returns
     * int: the length of the longest bitonic subarray
    */

    public static int longestBiotonicSubarray(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] inc = new int[n]; // Length of increasing subarray ending at each index
        int[] dec = new int[n]; // Length of decreasing subarray starting at each index

        // Initialize arrays
        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            dec[i] = 1;
        }

        // Compute increasing subarray lengths
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            }
        }

        // Compute decreasing subarray lengths
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                dec[i] = dec[i + 1] + 1;
            }
        }

        // Find the maximum length of a biotonic subarray
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, inc[i] + dec[i] - 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 4, 2, 1};
        System.out.println("Length of longest biotonic subarray: " + longestBiotonicSubarray(arr));
    }

}
