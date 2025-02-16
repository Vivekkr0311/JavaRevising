package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class FruitIntoBaskets_904 {
    private static int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n == 1) {
            return 1;
        }
        int totalAns = 0;
        HashMap<Integer, Integer> fruitCount = new HashMap<>();

        int i = 0, j = 0;
        while (j < n) {
            int curr = fruits[j];
            fruitCount.put(curr, fruitCount.getOrDefault(curr, 0) + 1);

            while (fruitCount.size() > 2) {
                int leftFruit = fruits[i];

                fruitCount.put(leftFruit, fruitCount.get(leftFruit) - 1);
                if (fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                i++;
            }

            totalAns = Math.max(totalAns, j - i + 1);
            j++;

            if (n - j + 1 < totalAns) {
                break;
            }
        }
        return totalAns;
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
    }
}
