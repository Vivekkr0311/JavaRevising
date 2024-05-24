package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.Scanner;

public class MaximumDepth {

    // Use case of post order DFS traversal

    static int maximumDepth(Node root, int depth){
        if(root == null){
            return depth;
        }

        return Math.max(maximumDepth(root.left, depth + 1), maximumDepth(root.right, depth + 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        Node root = tree.getRoot();

        System.out.println("Maximum depth of the tree is: " + maximumDepth(root, 0));
    }
}
