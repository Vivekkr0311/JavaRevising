package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.Scanner;

public class PathExistFromRootToLeaf {

    static boolean pathExist(Node root, int[] nums){
        if(root == null){
            return nums.length == 0;
        }

        return helper(root, nums, 0);
    }

    static boolean helper(Node root, int[] nums, int idx){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null && nums[idx] == root.value){
            return true;
        }

        return helper(root.left, nums, idx + 1) || helper(root.right, nums, idx + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        Node root = tree.getRoot();

        System.out.println("Number of nodes for your path ?");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter your nodes values: ");
        for(int i = 0; i < nums.length; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Path you entered exist ? " + pathExist(root, nums));
    }
}
