package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.Scanner;

public class CreateBST {

    static Node createTree(int[] nums, int start, int end){
        if(start == end){
            Node node = new Node(nums[start]);
            return node;
        }

        if(start > end){
            return null;
        }

        int rootIdx = (start + (end -  start)/2) + 1;
        Node root = new Node(nums[rootIdx]);
        root.right = createTree(nums, rootIdx + 1, end);
        root.left = createTree(nums, start, rootIdx - 1);
        return root;
    }

    private static void preetyDisplay(Node root){
        preetyDisplay(root, 0);

    }

    private static void preetyDisplay(Node node, int level){
        if(node == null){
            return;
        }

        preetyDisplay(node.right, level + 1);

        if(level != 0){
            for(int i = 0; i < level - 1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|-------->" + node.value);
        }else{
            System.out.println(node.value);
        }
        preetyDisplay(node.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of nodes value: ");
        int n = scanner.nextInt();
        int[] nodesValue = new int[n];
        System.out.println("Enter each value: ");
        for(int i = 0; i < n; i++){
            nodesValue[i] = scanner.nextInt();
        }
        Node root = createTree(nodesValue, 0, nodesValue.length - 1);
        preetyDisplay(root);
    }
}
