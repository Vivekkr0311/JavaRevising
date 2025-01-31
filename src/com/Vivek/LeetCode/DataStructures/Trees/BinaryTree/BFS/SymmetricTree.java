package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SymmetricTree {

    static boolean isSymmetric(Node root){
        if(root == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            Node left = queue.poll();
            Node right = queue.poll();

            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.value != right.value){
                return false;
            }


            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        System.out.println("Tree is symmetric: " + isSymmetric(root));
    }
}
