package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;
// https://leetcode.com/problems/subarray-sum-equals-k/description/
import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK_560 {
    private static int subarraySum(int[] nums, int k) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);

        for (int i : nums) {
            sum += i;
            int a = sum - k;

            if (map.containsKey(a)) {
                result += map.get(a);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the k: ");
        int k = scanner.nextInt();

        System.out.println("Number of subarrays with sum " + k + " is " + subarraySum(nums, k));
    }
}
