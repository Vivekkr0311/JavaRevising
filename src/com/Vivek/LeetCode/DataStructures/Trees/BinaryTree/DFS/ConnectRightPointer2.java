package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.Scanner;

public class ConnectRightPointer2 {

    static Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            if(root.right!=null){
                root.left.next=root.right;
            }
            else{
                root.left.next=findNext(root.next);
            }
        }
        if(root.right!=null && root.next!=null){
            root.right.next=findNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    static Node findNext(Node next){
        while(next!=null){
            if(next.left!=null){
                return next.left;
            }
            if(next.right!=null){
                return next.right;
            }
            next=next.next;
        }
        return next;
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
