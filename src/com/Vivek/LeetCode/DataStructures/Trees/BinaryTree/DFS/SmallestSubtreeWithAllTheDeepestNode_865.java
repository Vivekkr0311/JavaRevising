package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import java.util.Scanner;

public class SmallestSubtreeWithAllTheDeepestNode_865 {
    private static class Result {
        int depth;
        BinaryTree.Node node;

        Result(int depth, BinaryTree.Node node) {
            this.depth = depth;
            this.node = node;
        }
    }

    private static Result dfs(BinaryTree.Node root) {
        if (root == null) {
            return new Result(0, null);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth > right.depth) {
            return new Result(left.depth + 1, left.node);
        }
        if (right.depth > left.depth) {
            return new Result(right.depth + 1, right.node);
        }

        return new Result(left.depth + 1, root);
    }

    private static BinaryTree.Node subTreeWithAllDeepest(BinaryTree.Node root) {
        return dfs(root).node;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        BinaryTree.Node root = tree.getRoot();

        System.out.println("Common ancestor with deepest node is: " + subTreeWithAllDeepest(root));
    }
}
