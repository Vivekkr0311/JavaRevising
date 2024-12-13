package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class LongestHarmoniousSubsequence {

    private static int findLHS(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int ans = 0;
        for(int k : map.keySet()){
            if(map.containsKey(k + 1)){
                ans = Math.max(ans,
                        map.get(k) + map.get(k + 1)
                );
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many element ? ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Longest harmonious subsequence length is: " + findLHS(nums));
    }
}
