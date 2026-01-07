package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.Scanner;

public class MaximumProductOfSplittedBinaryTree_1339 {
    static long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    private static int getSum (BinaryTree.Node node) {
        if (node == null) {
            return 0;
        }

        int leftSum = getSum(node.left);
        int rightSum = getSum(node.right);
        return leftSum + rightSum + node.value;
    }

    private static int dfsCompute (BinaryTree.Node node, int totalSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = dfsCompute(node.left, totalSum);
        int rightSum = dfsCompute(node.right, totalSum);
        int subTreeSum = leftSum + rightSum + node.value;

        long product = (long) subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);
        return subTreeSum;
    }

    private static int maxProduct(BinaryTree.Node root) {
        int totalSum = getSum(root);
        dfsCompute(root, totalSum);
        return (int) (maxProduct % MOD);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);

        BinaryTree.Node root = tree.getRoot();
        int result = maxProduct(root);
        System.out.println(result);
    }
}
