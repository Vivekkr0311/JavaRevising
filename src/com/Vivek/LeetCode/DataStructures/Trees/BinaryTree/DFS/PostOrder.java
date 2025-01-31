package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

public class PostOrder {

    static List<Integer> postorderTraversal(Node root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        left.addAll(right);
        left.add(root.value);
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        System.out.println("Post order: " + postorderTraversal(root));
    }
}
