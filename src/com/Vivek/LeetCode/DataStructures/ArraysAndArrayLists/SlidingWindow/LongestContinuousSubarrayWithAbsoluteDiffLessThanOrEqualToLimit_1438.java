package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.*;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_1438 {
    private static boolean checkDiff(int[] nums, int start, int end, int limit) {
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (Math.abs(nums[i] - nums[j]) > limit) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int longestSubarrayBruteForce(int[] nums, int limit) {
        int ansLength = 0;

        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                if (checkDiff(nums, left, right, limit)) {
                    ansLength = Math.max(ansLength, right - left + 1);
                }
            }
        }
        return ansLength;
    }

    private static class Pair {
        private int value;
        private int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return this.value;
        }

        public int getIndex() {
            return this.index;
        }
    }

    private static int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int ansLength = 0;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y.getValue(), x.getValue()));
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x, y) -> Integer.compare(x.getValue(), y.getValue()));

        while (right < nums.length) {
            maxHeap.add(new Pair(nums[right], right));
            minHeap.add(new Pair(nums[right], right));

            while (!minHeap.isEmpty() && Math.abs(minHeap.peek().getValue() - maxHeap.peek().getValue()) > limit) {
                left = Math.min(
                        minHeap.peek().getIndex(), maxHeap.peek().getIndex()
                ) + 1;

                while (!minHeap.isEmpty() && minHeap.peek().getIndex() < left) {
                    minHeap.poll();
                }

                while (!maxHeap.isEmpty() && maxHeap.peek().getIndex() < left) {
                    maxHeap.poll();
                }
            }

            ansLength = Math.max(ansLength, right - left + 1);
            right++;
        }
        return ansLength;
    }

    private static int longestSubarrayUsingTreeSet(int[] nums, int limit) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ansLength = 0;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        while (right < n) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);

            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);

                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left++;
            }

            ansLength = Math.max(ansLength, right - left + 1);
            right++;
        }
        return ansLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the limit: ");
        int limit = scanner.nextInt();

        System.out.println("Longest subarray length with absolute diff " + limit + " is " + longestSubarrayBruteForce(nums, limit));
        System.out.println("Longest subarray length with absolute diff " + limit + " is " + longestSubarray(nums, limit));
        System.out.println("Longest subarray length with absolute diff " + limit + " is " + longestSubarrayUsingTreeSet(nums, limit));
    }
}
