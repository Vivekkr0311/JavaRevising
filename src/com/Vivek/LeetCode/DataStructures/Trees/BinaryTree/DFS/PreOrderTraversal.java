package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class PreOrderTraversal {

    static List<Integer> preorderTraversal(Node root){
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.value);

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        left.addAll(right);
        list.addAll(left);
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        Node root = tree.getRoot();

        System.out.println("Preorder traversal of tree is: " + preorderTraversal(root));
    }
}
