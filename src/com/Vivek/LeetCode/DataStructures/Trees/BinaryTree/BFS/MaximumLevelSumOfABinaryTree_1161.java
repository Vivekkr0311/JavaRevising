package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaximumLevelSumOfABinaryTree_1161 {
    private static int bfs(BinaryTree.Node root) {
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        int ansLevel = 0;
        long maxSum = Long.MIN_VALUE;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            long levelSum = 0;

            for (int i = 0; i < size; i++) {
                BinaryTree.Node node = queue.poll();
                levelSum += node.value;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                ansLevel = level;
            }
        }

        return ansLevel;
    }

    private static int maxLevelSum(BinaryTree.Node root) {
        return bfs(root);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);

        BinaryTree.Node root = tree.getRoot();
        int result = maxLevelSum(root);
        System.out.println(result);
    }
}
