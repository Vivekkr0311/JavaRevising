package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.Scanner;

public class HasPathSum {

    static boolean hasPathSum(Node root, int targetSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && targetSum - root.value == 0){
            return true;
        }


        boolean left = hasPathSum(root.left, targetSum - root.value);
        boolean right = false;
        if(!left){
            right = hasPathSum(root.right, targetSum - root.value);
        }

        return left || right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        Node root = tree.getRoot();
        System.out.println("Enter the sum you wanna check: ");
        int sum = scanner.nextInt();
        System.out.println(sum + " exist: " + hasPathSum(root, sum));
    }
}
