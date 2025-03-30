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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println("Partion size: " + partitionLabels(s));
    }
}
