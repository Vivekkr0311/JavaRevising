package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class RabbitsInForest_781 {
    private static int leftIdx(int[] nums, int start, int end, int target) {
        int idx = -1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] == target) {
                idx = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }

        return idx;
    }

    private static int rightIdx(int[] nums, int start, int end, int target) {
        int idx = -1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                idx = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return idx;
    }

    private static int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int n = answers.length - 1;
        int count = 0;

        int currLength = 0;
        for (int i = 0; i <= n; i += currLength) {
            int left = leftIdx(answers, i, n, answers[i]);
            int right = rightIdx(answers, i, n, answers[i]);

            currLength = right - left + 1;
            int groupSize = answers[i] + 1;
            int numGroups = (currLength + groupSize - 1) / groupSize;  // ceil logic

            count += numGroups * groupSize;
        }

        return count;
    }

    private static int numRabbits_(int[] answers) {
        int[] map = new int[1001];
        for (int x : answers) {
            map[x]++;
        }

        int count = 0;
        for (int x = 0; x < map.length; x++) {
            if (map[x] > 0) {
                int freq = map[x];
                int groupSize = x + 1;
                int numGroups = (freq + x) / groupSize;
                count += numGroups * groupSize;

                map[x] = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rabbits: ");
        int n = scanner.nextInt();

        int[] answers = new int[n];
        System.out.println("Enter the answers of the rabbits: ");
        for (int i = 0; i < n; i++) {
            answers[i] = scanner.nextInt();
        }

        System.out.println("Minimum number of rabbits: " + numRabbits(answers));
        System.out.println("Minimum number of rabbits: " + numRabbits_(answers));
    }
}