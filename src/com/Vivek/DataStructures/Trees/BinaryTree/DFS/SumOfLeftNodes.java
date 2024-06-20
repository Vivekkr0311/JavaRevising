package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.Scanner;

public class SumOfLeftNodes {

    static int helper(Node root, int sum, boolean leftCall){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null && leftCall){
            return sum + root.value;
        }

        if(root.left == null && root.right == null && !leftCall){
            return sum;
        }

        int left = helper(root.left, sum, true);
        int right = helper(root.right, sum, false);
        return left + right;
    }

    static int sumOfLeftLeaves(Node root){
        if(root == null){
            return 0;
        }

        return helper(root, 0, false);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        System.out.println("Sum of all left leaves: " + sumOfLeftLeaves(root));
    }
}
