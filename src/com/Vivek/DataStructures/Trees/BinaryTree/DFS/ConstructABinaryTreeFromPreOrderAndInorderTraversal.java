package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.Arrays;
import java.util.Scanner;

public class ConstructABinaryTreeFromPreOrderAndInorderTraversal {

    static Node buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        }

        int r = preorder[0];
        int index = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == r){
                index = i;
            }
        }

        Node node = new Node(r);
        node.left = buildTree(Arrays.copyOfRange(preorder,  1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }

    private static void preetyDisplay(Node node){
        preetyDisplay(node, 0);
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
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        System.out.println("Enter inorder: ");
        int[] inorder = new int[n];
        for(int i = 0; i < n; i++){
            inorder[i] = scanner.nextInt();
        }

        System.out.println("Enter preorder: ");
        int[] preorder = new int[n];
        for(int i = 0; i < n; i++){
            preorder[i] = scanner.nextInt();
        }

        Node root = buildTree(preorder, inorder);
        preetyDisplay(root);
    }
}
