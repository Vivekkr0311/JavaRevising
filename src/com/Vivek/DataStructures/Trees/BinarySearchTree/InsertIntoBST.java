package com.Vivek.DataStructures.Trees.BinarySearchTree;

import com.Vivek.DataStructures.Trees.BinarySearchTree.BST.Node;

import java.util.Scanner;

public class InsertIntoBST {

    private static Node insertIntoBST(Node root, int val) {
        if(root == null){
            return new Node(val);
        }

        if(root.value > val){
            root.left = insertIntoBST(root.left, val);
        }
        if(root.value < val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BST tree = new BST();
        tree.populate(scanner);
        Node root = tree.getRoot();

        System.out.println("Enter number to be inserted: ");
        int n = scanner.nextInt();
        insertIntoBST(root, n);
        tree.preetyDisplay();
    }
}
