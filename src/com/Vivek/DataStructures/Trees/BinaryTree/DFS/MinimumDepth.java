package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.Scanner;

public class MinimumDepth {

    // Use case of post order DFS traversal

    static int minimumDepth(Node root){
        if(root == null){
            return 0;
        }

        if(root.left == null){
            return minimumDepth(root.right) + 1;
        }else if(root.right == null){
            return minimumDepth(root.left) + 1;
        }else{
            return Math.min(
                    minimumDepth(root.left),
                    minimumDepth(root.right)
            ) + 1;
        }
    }

    static int minimumDepthTwo(Node root){
        if(root == null){
            return 0;
        }

        return helper(root);
    }

    static int helper(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        return Math.min(helper(root.left), helper(root.right)) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        BinaryTree.Node root = tree.getRoot();

        System.out.println("Maximum depth of the tree is: " + minimumDepth(root));
        System.out.println("Maximum depth of the tree is: " + minimumDepthTwo(root));
    }
}