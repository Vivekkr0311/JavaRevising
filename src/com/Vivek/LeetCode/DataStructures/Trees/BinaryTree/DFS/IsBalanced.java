package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.Scanner;

public class IsBalanced {

    static int height(Node node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null && node != null){
            return 1;
        }

        int left = height(node.left) + 1;
        int right = height(node.right) + 1;
        return Math.max(left, right);
    }

    static boolean isBalanced(Node root){
        if(root == null){
            return true;
        }

        boolean leftCall = isBalanced(root.left);
        boolean rightCall = isBalanced(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return !(Math.abs(leftHeight - rightHeight) > 1) && leftCall && rightCall;
    }

    static int checkHeight(Node node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null && node != null){
            return 1;
        }

        int left = checkHeight(node.left);
        if(left == -1){
            return -1;
        }

        int right = checkHeight(node.right);
        if(right == -1){
            return -1;
        }

        if(Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    static boolean isBalancedTwo(Node root){
        if(checkHeight(root) == -1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);

        tree.preetyDisplay();
        Node root = tree.getRoot();
        System.out.println("Is tree balanced: " + isBalanced(root));
    }
}
