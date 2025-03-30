package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.TwoPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartitionLabels_763 {
    private static List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map[charArray[i] - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int i = 0;

        while (i < charArray.length) {
            int end = map[charArray[i] - 'a'];

            int j = i;
            while (j < end) {
                end = Math.max(end, map[charArray[j] - 'a']);
                j++;
            }
            ans.add(j - i + 1);
            i = j + 1;
        }
        return ans;
    }

    // in less code
    private static List<Integer> partitionLabels_(String s) {
        int[] map = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map[charArray[i] - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int start = 0;
        int end = 0;
        while (i < charArray.length) {
            end = Math.max(end, map[charArray[i] - 'a']);

            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Partition size: " + partitionLabels(s));
        System.out.println("Partition size: " + partitionLabels_(s));
    }
}
