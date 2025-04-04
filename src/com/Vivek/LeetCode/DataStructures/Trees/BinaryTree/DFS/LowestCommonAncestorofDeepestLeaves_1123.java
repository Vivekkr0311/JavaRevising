package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.Scanner;

public class LowestCommonAncestorofDeepestLeaves_1123 {
    private static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private static Node findLCA(Node root, int currDepth, int maxDepth) {
        if (root == null) {
            return null;
        }

        if (currDepth == maxDepth) {
            return root;
        }

        Node left = findLCA(root.left, currDepth + 1, maxDepth);
        Node right = findLCA(root.right, currDepth + 1, maxDepth);

        if (left != null && right != null) {
            return root;
        }

        return right != null ? right : left;
    }

    private static Node lcaDeepestLeaves(Node root) {
        int maxDepth = maxDepth(root);
        return findLCA(root, 1, maxDepth);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        BinaryTree.Node root = tree.getRoot();

        System.out.println("Common ancestor is: " + lcaDeepestLeaves(root).value);
    }
}
