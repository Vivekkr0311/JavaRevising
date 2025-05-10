package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MinimumEqualSumOfTwoArraysAfterReplacingZeros_2918 {
    private static long minSumUsingStreams(int[] nums1, int[] nums2) {
        AtomicInteger cntZeros1 = new AtomicInteger(0);
        AtomicInteger cntZeros2 = new AtomicInteger(0);

        long sum1 = Arrays.stream(nums1)
                .map(x -> {
                    if(x == 0) cntZeros1.incrementAndGet();
                    return x == 0 ? 1 : x;
                })
                .asLongStream()
                .sum();

        long sum2 = Arrays.stream(nums2)
                .map(x -> {
                    if(x == 0) cntZeros2.incrementAndGet();
                    return x == 0 ? 1 : x;
                }).asLongStream()
                .sum();

        if(sum1 < sum2 && cntZeros1.get() == 0){
            return -1;
        }

        if(sum1 > sum2 && cntZeros2.get() == 0){
            return -1;
        }

        return Math.max(sum1, sum2);
    }

    private static long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        int countNum1Zero = 0;
        int countNum2Zero = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                sum1 += 1;
                countNum1Zero += 1;
            } else {
                sum1 += nums1[i];
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                sum2 += 1;
                countNum2Zero += 1;
            } else {
                sum2 += nums2[i];
            }
        }

        if (sum1 < sum2 && countNum1Zero == 0) {
            return -1;
        }

        if (sum1 > sum2 && countNum2Zero == 0) {
            return -1;
        }

        return Math.max(sum1, sum2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the n for nums1: ");
        int n = scanner.nextInt();

        System.out.println("Enter elements of nums1: ");
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.println("Enter the n for nums2: ");
        int n2 = scanner.nextInt();

        System.out.println("Enter elements of nums2: ");
        int[] nums2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }

        System.out.println("Answer: " + minSum(nums1, nums2));
        System.out.println("Answer: " + minSumUsingStreams(nums1, nums2));
    }
}