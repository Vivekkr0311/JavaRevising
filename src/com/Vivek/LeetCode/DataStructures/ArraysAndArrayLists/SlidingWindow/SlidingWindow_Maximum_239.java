package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SlidingWindow_Maximum_239 {
    private static int findMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    private static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        int ansArrayLength = n - k + 1;
        if (n == k) {
            int max = findMax(nums, 0, n);
            int[] ans = new int[1];
            ans[0] = max;
            return ans;
        }

        int[] ans = new int[ansArrayLength];
        int idx = 0;
        for (int i = 0; i <= n - k; i++) {
            int max = findMax(nums, i, i + k);
            ans[idx++] = max;
        }

        return ans;
    }

    private static int[] maxSlidingWindowSimpleCode(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }

            queue.addLast(i);

            if (queue.getFirst() + k == i) {
                queue.removeFirst();
            }

            if (i >= k - 1) {
                res[j] = nums[queue.getFirst()];
                j++;
            }
        }
        return res;
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;
        Deque<Integer> deq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deq.isEmpty() && deq.peekFirst() <= i - k) {
                deq.pollFirst();
            }

            while (!deq.isEmpty() && nums[i] >= nums[deq.peekLast()]) {
                deq.pollLast();
            }

            deq.offerLast(i);

            if (i >= k - 1) {
                ans[idx++] = nums[deq.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Maximum of all " + k + " sized subarrays: " + Arrays.toString(maxSlidingWindowBruteForce(nums, k)));
        System.out.println("Maximum of all " + k + " sized subarrays: " + Arrays.toString(maxSlidingWindow(nums, k)));
        System.out.println("Maximum of all " + k + " sized subarrays: " + Arrays.toString(maxSlidingWindowSimpleCode(nums, k)));
    }
}