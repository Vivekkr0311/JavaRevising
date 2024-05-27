package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InorderTraversal {

    static List<Integer> inorderTraversal(Node root){
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> left = inorderTraversal(root.left);
        left.add(root.value);
        List<Integer> right = inorderTraversal(root.right);
        left.addAll(right);
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        Node root = tree.getRoot();

        List<Integer> result = inorderTraversal(root);
        System.out.println(result);
    }
}
