package com.Vivek.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashMap;
import java.util.Scanner;

public class FruitIntoBaskets {
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
        }
        return totalAns;
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
    }
}
