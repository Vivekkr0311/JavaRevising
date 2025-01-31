package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.Scanner;

public class SameTree {

    static boolean isSameTree(Node p, Node q){
        if(p == null && q == null){
            return true;
        }
        if(p == null && q != null){
            return false;
        }
        if(p != null && q == null){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree1 = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();

        tree1.populate(scanner);
        tree2.populate(scanner);

        tree1.preetyDisplay();
        tree2.preetyDisplay();

        Node p = tree1.getRoot();
        Node q = tree2.getRoot();
        System.out.println("Are tree same: " + isSameTree(p, q));
    }
}
