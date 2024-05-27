package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.ArrayList;
import java.util.Scanner;

public class KthSmallestInBST {

    static ArrayList<Integer> addElements(Node root){
        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> left = addElements(root.left);
        left.add(root.value);
        ArrayList<Integer> right = addElements(root.right);
        left.addAll(right);
        return left;
    }

    static int kthSmallest(Node root, int k){
        if(root == null){
            return -1;
        }
        ArrayList<Integer> list = addElements(root);
        return list.get(k - 1);
    }

    // Fastest solution
    static int count = 0;
    public static Node helper(Node root, int k){
        if(root == null){
            return null;
        }

        Node left = helper(root.left, k);
        if(left != null){
            return left;
        }
        count++;

        if(count == k){
            return root;
        }
        return helper(root.right, k);
    }

    public static int kthSmallestTwo(Node root, int k){
        return helper(root, k).value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        Node root = tree.getRoot();

        System.out.println("Enter value of k: ");
        int k = scanner.nextInt();

        System.out.println("Kth smallest element in the binary search tree is: " + kthSmallest(root, k));
        System.out.println("Kth smallest element in the binary search tree is: " + kthSmallestTwo(root, k));
    }
}
