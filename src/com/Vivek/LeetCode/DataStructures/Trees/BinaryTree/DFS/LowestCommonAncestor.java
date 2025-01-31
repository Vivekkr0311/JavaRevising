package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.Scanner;

public class LowestCommonAncestor {

    public static Node lowestCommonAncestorTwo(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) return root;

        Node left = lowestCommonAncestorTwo(root.left, p , q);
        Node right = lowestCommonAncestorTwo(root.right, p , q);
        if (left != null && right != null) return root;
        return left == null ? right == null ? null : right : left;
    }


    static Node lowestCommonAncestor(Node root, Node p, Node q){
        if(root == null){
            return null;
        }

        if(root.value == p.value || root.value == q.value){
            return root;
        }

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        Node root = tree.getRoot();

        System.out.println("Enter node p: ");
        Node p = new Node(scanner.nextInt());
        System.out.println("Enter node q: ");
        Node q = new Node(scanner.nextInt());

        System.out.println("Common ancestor is: " + lowestCommonAncestor(root, p, q).value);
    }
}
