package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.Scanner;

public class PopulatingNextRightPointersInEachNodeInPerfectBinaryTree {

    static Node connect(Node root){
        if(root == null){
            return root;
        }

        helper(root.left, root.right);
        return root;
    }

    static void helper(Node right, Node left){
        if (left == null || right == null) {
            return;
        }

        // Connect the left node's next to the right node
        left.next = right;

        // Connect the children of the left and right nodes
        helper(left.left, left.right);
        helper(right.left, right.right);

        // Connect the right child of the left node to the left child of the right node
        helper(left.right, right.left);
    }
    
    static void print(Node root){
        Node leftPointer = root;
        while(leftPointer != null){
            Node temp = leftPointer;
            while(temp.next != null){
                System.out.print(temp.value + "->");
                temp = temp.next;
            }
            leftPointer = leftPointer.left;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        root = connect(root);
        print(root);
    }
}
