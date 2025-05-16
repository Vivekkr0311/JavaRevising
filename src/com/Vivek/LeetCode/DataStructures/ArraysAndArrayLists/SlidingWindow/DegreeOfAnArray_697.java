package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.*;

public class DegreeOfAnArray_697 {
    private static int[] findDegree(int[] nums) {
        int[] elementAndDegree = new int[2];
        int[] map = new int[50000];

        for (int i : nums) {
            map[i]++;
            if (map[i] > elementAndDegree[1]) {
                elementAndDegree[0] = i;
                elementAndDegree[1] = map[i];
            }
        }
        return elementAndDegree;
    }

    private static int[] findDegree_(int[] nums) {
        int[] elementAndDegree = new int[2]; // [element, frequency]
        HashMap<Integer, int[]> table = new HashMap<>();
        // int[0] = start index, int[1] = end index, int[2] = frequency

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!table.containsKey(num)) {
                table.put(num, new int[] { i, i, 1 });
            } else {
                int[] arr = table.get(num);
                arr[1] = i; // update end index
                arr[2] += 1; // increment frequency
            }
        }

        int maxFreq = 0;
        int minLen = Integer.MAX_VALUE;

        for (Map.Entry<Integer, int[]> entry : table.entrySet()) {
            int key = entry.getKey();
            int[] val = entry.getValue();
            int freq = val[2];
            int len = val[1] - val[0] + 1;

            if (freq > maxFreq || (freq == maxFreq && len < minLen)) {
                elementAndDegree[0] = key;
                elementAndDegree[1] = freq;
                maxFreq = freq;
                minLen = len;
            }
        }

        return elementAndDegree;
    }

    private static int findShortestSubarray(int[] nums) {
        int[] degree = findDegree_(nums);
        int n = nums.length;
        int right = 0;
        int left = 0;
        int ansLength = Integer.MAX_VALUE;
        int windowDegree = 0;
        while (right < n) {
            if (nums[right] == degree[0]) {
                windowDegree++;
            }

            while (windowDegree == degree[1]) {
                ansLength = Math.min(ansLength, right - left + 1);
                if (nums[left] == degree[0]) {
                    windowDegree--;
                }
                left++;
            }
            right++;
        }
        return ansLength;
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

        System.out.println("Result: " + findShortestSubarray(nums));
    }
}
