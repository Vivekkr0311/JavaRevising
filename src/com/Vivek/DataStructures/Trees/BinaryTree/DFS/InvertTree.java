package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.Scanner;

public class InvertTree {

    static Node invert(Node root){
        if(root == null){
            return null;
        }

        Node leftNode = invert(root.left);
        Node rightNode = invert(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }

    static void preetyDisplay(Node root){
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
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        root = invert(root);
        preetyDisplay(root);
    }
}
