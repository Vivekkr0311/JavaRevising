package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.Scanner;

public class CountCompleteTreeNodesUsingDFS {

    private static int countLeftHeight(Node root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }

    private static int countRightHeight(Node root){
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    }

    private static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int leftHeight = countLeftHeight(root);
        int rightHeight = countRightHeight(root);

        if(leftHeight == rightHeight){
            // This means tree is perfect
            // leftHeight and rightHeight is same we can take any one of them
            // below means 2 ^ (leftHeight) - 1
            // which total number of nodes.
            return (1 << leftHeight) - 1;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        System.out.println("Number of nodes: " + countNodes(root));
    }
}
