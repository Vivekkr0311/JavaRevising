package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;

public class PopulatingNextRightPointersinEachNode2 {

    static void helper(Node root){
        if(root == null){
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node temp = null;

            for(int i = 0; i < size; i++){
                Node curr = queue.poll();
                if(curr.right != null){
                    queue.add(curr.right);
                }
                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(temp != null){
                    temp.next = curr;
                }
                temp = curr;
            }
            temp.next = null;
        }
    }

    static Node connect(Node root){
        helper(root);
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        connect(root);
    }
}
