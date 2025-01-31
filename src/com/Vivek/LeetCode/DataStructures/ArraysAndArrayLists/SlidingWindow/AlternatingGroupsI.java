package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class AlternatingGroupsI {
    private static int numberOfAlternatingGroups(int[] colors){
        int ans = 0;
        for(int i = 0; i < colors.length; i++){
            int leftIdx = i - 1;
            int rightIdx = i + 1;
            if(i == 0){
                leftIdx = colors.length - 1;
            }
            if(i == colors.length - 1){
                rightIdx = 0;
            }

            int middle = colors[i];
            int left = colors[leftIdx];
            int right = colors[rightIdx];
            if(left != middle && middle != right){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements? ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for(int i = 0 ; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Number of alternating group is: " + numberOfAlternatingGroups(nums));
    }
}
