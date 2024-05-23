package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.Scanner;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

public class DiameterOfTree {

    static int diameter = 0;
    static int diameterOfBinaryTree(Node root) {
        height(root);
        return diameter-1;
    }
    static int height(Node node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        BinaryTree.Node root = tree.getRoot();

        System.out.println("Diameter of the tree is: " + diameterOfBinaryTree(root));
    }
}
