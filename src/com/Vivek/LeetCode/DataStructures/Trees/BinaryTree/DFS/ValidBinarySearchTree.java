package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.Scanner;

public class ValidBinarySearchTree {

    static boolean isValid(Node root){
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return true;
        }
        if(root.right == null && root.left != null){
            // right child is null
            return root.value >= root.left.value && isValid(root.left) && isValid(root.right);
        }else if(root.right != null && root.left == null){
            // left child is null
            return root.value <= root.right.value && isValid(root.left) && isValid(root.right);
        }else{
            // neight left child is null nor right child is null
            return root.value <= root.right.value && root.value >= root.left.value && isValid(root.left) && isValid(root.right);
        }
    }

    static boolean helper(Node node, Integer min, Integer max){
        if(node == null){
            return true;
        }

        if(min != null && node.value <= min){
            return false;
        }
        if(max != null && node.value >= max){
            return false;
        }

        boolean leftCall = helper(node.left, min, node.value);
        boolean rightCall = helper(node.right, node.value, max);
        return leftCall && rightCall;
    }

    static boolean isValidBST(Node root) {
        return helper(root, null, null);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);

        Node root = tree.getRoot();
        System.out.println("Binary Search tree is valid: " + isValid(root));
        System.out.println("Binary Search tree is valid: " + isValidBST(root));
    }
}
