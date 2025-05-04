package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists;

import java.util.*;

public class NumberOfEquivalentDominoPairs_1128 {
    private static int numEquivDominoesPairs(int[][] dominoes) {
        int result = 0;
        int[] map = new int[100];

        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);

            int key = a * 10 + b;
            result += map[key];
            map[key]++;
        }
        return result;
    }

    private static int numEquivDominoesPairs_(int[][] dominoes) {
        int result = 0;

        for (int i = 0; i < dominoes.length; i++) {
            int[] firstDomino = dominoes[i];
            for (int j = i + 1; j < dominoes.length; j++) {
                int[] secondDomino = dominoes[j];

                boolean condition1 = firstDomino[0] == secondDomino[0] && firstDomino[1] == secondDomino[1];
                boolean condition2 = firstDomino[1] == secondDomino[0] && firstDomino[0] == secondDomino[1];

                if (condition1 || condition2) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of dominoes: ");
        int n = scanner.nextInt();

        int[][] dominoes = new int[n][2];
        System.out.println("Enter each domino sides: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Domino: " + (i + 1));
            dominoes[i][0] = scanner.nextInt();
            dominoes[i][1] = scanner.nextInt();
        }

        System.out.println("Number of dominoes which are equal: " + numEquivDominoesPairs(dominoes));
        System.out.println("Number of dominoes which are equal: " + numEquivDominoesPairs_(dominoes));
    }
}