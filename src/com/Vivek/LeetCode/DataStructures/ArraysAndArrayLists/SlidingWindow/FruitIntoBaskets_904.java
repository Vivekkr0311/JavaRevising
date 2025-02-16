package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class FruitIntoBaskets_904 {
    private static int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        int n = fruits.length;
        int ans = 0;
        int[] count = new int[n];
        int unique = 0;

        while (j < n) {
            if (count[fruits[j]]++ == 0) {
                unique++;
            }

            while (unique > 2) {
                if (--count[fruits[i]] == 0) {
                    unique--;
                }
                i++;
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    private static int totalFruitBruteForce(int[] fruits) {
        HashMap<Integer, Integer> picked_tree_id = new HashMap<>();

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < fruits.length; i++) {
            int local_count = 0;
            for (int j = i; j < fruits.length; j++) {
                picked_tree_id.put(fruits[j], picked_tree_id.getOrDefault(fruits[j], 0) + 1);

                if (picked_tree_id.size() == 3) {
                    picked_tree_id.remove(fruits[j]);
                    break;
                }
            }

            for (Integer key : picked_tree_id.keySet()) {
                local_count += picked_tree_id.get(key);
            }
            ans = Math.max(ans, local_count);
            picked_tree_id.clear();
        }
        return ans;
    }

    private static int totalFruitSlidingWindow(int[] fruits) {
        int i = 0;
        int j = 0;
        int n = fruits.length;
        int ans = Integer.MIN_VALUE;
        HashMap<Integer, Integer> treeMap = new HashMap<>();

        while (j < n) {
            treeMap.put(fruits[j], treeMap.getOrDefault(fruits[j], 0) + 1);

            while (treeMap.size() > 2) {
                treeMap.put(fruits[i], treeMap.get(fruits[i]) - 1);
                if (treeMap.get(fruits[i]) == 0) {
                    treeMap.remove(fruits[i]);
                }
                i++;
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of trees: ");
        int n = scanner.nextInt();

        int[] fruits = new int[n];
        System.out.println("Enter each tree id: ");
        for (int i = 0; i < n; i++) {
            fruits[i] = scanner.nextInt();
        }

        System.out.println("Maximum fruits can be picked: " + totalFruit(fruits));
        System.out.println("Maximum fruits can be picked: " + totalFruitBruteForce(fruits));
        System.out.println("Maximum fruits can be picked: " + totalFruitSlidingWindow(fruits));
    }
}
