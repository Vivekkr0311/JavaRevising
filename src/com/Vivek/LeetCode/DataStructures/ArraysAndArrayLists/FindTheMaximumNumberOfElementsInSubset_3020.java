package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.HashMap;
import java.util.Scanner;

public class FindTheMaximumNumberOfElementsInSubset_3020 {
    private static HashMap<Integer, Integer> getCountMap(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    private static int getMaxLength(int n, HashMap<Integer, Integer> map){
        if (n == 1) {
            int count = map.get(1);
            return (count % 2 == 0) ? count - 1 : count;
        }

        int ans = 0;
        long current = n;

        while (map.containsKey((int) current)) {

            int freq = map.get((int) current);

            if (freq >= 2) {
                ans += 2;
            } else {
                ans += 1;
                break;
            }

            current = current * current;
            if (current > Integer.MAX_VALUE) {
                ans--;
                break;
            }
            if (!map.containsKey((int) current)) {
                ans--;
                break;
            }
        }

        return ans;
    }

    private static int helper(int[] nums){
        HashMap<Integer, Integer> map = getCountMap(nums);

        int ans = 0;
        for (int num : nums){
            ans = Math.max(ans, getMaxLength(num, map));
        }
        return ans;
    }

    private static int maximumLength(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return 1;
        }

        return helper(nums);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(maximumLength(nums));
    }
}
