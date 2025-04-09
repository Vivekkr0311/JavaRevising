package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummaryRanges_228 {
    private static List<String> summaryRanges(int[] nums) {
        int n = nums.length - 1;
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i <= n) {
            int start = nums[i];
            int temp = start;
            while (i + 1 <= n && temp + 1 == nums[i + 1]) {
                temp = nums[i + 1];
                i++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(start);
            if (start < temp) {
                sb.append("->");
                sb.append(temp);
            }
            ans.add(sb.toString());
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Summary ranges: " + summaryRanges(nums));
    }
}