package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTwoNonOverlappingSubarraysEachWithTargetSum_1477 {

    private static int minSumOfLengths(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int n = arr.length;
        int sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while (right < n) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int currLength = right - left + 1;
                minHeap.add(currLength);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        int size = minHeap.size();

        return !(size > 1) ? -1 : minHeap.poll() + minHeap.poll();
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

        System.out.println("Enter target: ");
        int target = scanner.nextInt();

        System.out.println("Number of subarrays which are non-overlapping with target sum: " + minSumOfLengths(nums, target));
    }
}