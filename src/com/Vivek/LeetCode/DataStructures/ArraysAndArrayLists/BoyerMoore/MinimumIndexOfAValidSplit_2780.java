package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.BoyerMoore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MinimumIndexOfAValidSplit_2780 {

    private static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i : nums) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            map1.put(x, map1.getOrDefault(x, 0) + 1);
            map2.put(x, map2.getOrDefault(x, 0) - 1);

            int leftArraySize = (i + 1);
            int rightArraySize = (n - i - 1);

            if (map1.get(nums.get(i)) * 2 > leftArraySize && map2.get(nums.get(i)) * 2 > rightArraySize) {
                return i;
            }
        }
        return -1;
    }

    private static int minimumIndexMajorityElementConcept(List<Integer> nums) {
        int n = nums.size();

        int maj = -1;
        int count = 0;

        // Step 1: Find majority element using Boyer-Moore Voting Algorithm
        for (int num : nums) {
            if (count == 0) {
                maj = num;
                count = 1;
            } else if (num == maj) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Count how many times majority element occurs
        int majCount = 0;
        for (int num : nums) {
            if (num == maj) {
                majCount++;
            }
        }

        // Step 3: Try splitting at every index to check conditions
        count = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == maj) {
                count++;
            }

            int remainingCount = majCount - count;
            int n1 = i + 1;
            int n2 = n - i - 1;

            if (count * 2 > n1 && remainingCount * 2 > n2) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        List<Integer> nums = new ArrayList<>(n);
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }

        System.out.println("Split can be made on: " + minimumIndex(nums));
        System.out.println("Split can be made on: " + minimumIndexMajorityElementConcept(nums));
    }
}
