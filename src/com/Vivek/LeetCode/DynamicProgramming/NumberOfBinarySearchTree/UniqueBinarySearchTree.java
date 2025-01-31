package com.Vivek.LeetCode.DynamicProgramming.NumberOfBinarySearchTree;

import java.util.Scanner;

public class UniqueBinarySearchTree {

    private static int numTree(int n){
        // Initialize an array to store the number of unique BSTs for each number of nodes
        int[] dp = new int[n + 1];

        // There is one unique BST with 0 nodes (empty tree)
        dp[0] = 1;

        for (int nodes = 1; nodes <= n; nodes++) {
            int total = 0;
            for (int root = 1; root <= nodes; root++) {
                int left = root - 1;
                int right = nodes - root;
                total += dp[left] * dp[right];
            }
            dp[nodes] = total;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = scanner.nextInt();

        System.out.println("Number of unique binary search tree possible: " + numTree(n));
    }
}
