package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.Scanner;

public class MaximumPathSum {

    static int GLOBAL_MAX = Integer.MIN_VALUE;
    static int helper(Node root){
        if(root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + root.value;
        GLOBAL_MAX = Math.max(GLOBAL_MAX, pathSum);
        return Math.max(left, right) + root.value;
    }
    static int maxPathSum(Node root){
        helper(root);
        return GLOBAL_MAX;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        Node root = tree.getRoot();

        System.out.println("Maximum path sum: " + maxPathSum(root));
    }
}
