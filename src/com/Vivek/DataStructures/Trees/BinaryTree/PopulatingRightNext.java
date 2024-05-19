package com.Vivek.DataStructures.Trees.BinaryTree;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PopulatingRightNext {

    static void populateRightNext(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            if(curr.left != null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }

            curr.next = queue.peek();
        }
    }

    static Node populateRightNextTwo(Node root){
        if(root == null){
            return null;
        }

        Node leftMost = root;
        while(leftMost.left != null){
            Node curr = leftMost;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }

            leftMost = leftMost.left;
        }
        return root;
    }

    static void traversingViaNext(Node root){
        Node temp = root;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static void traversingViaNextTwo(Node root){
        Node leftMost = root;
        Node curr = root;

        while(leftMost != null){
            System.out.print(curr.value + " -> ");
            if(curr.next == null){
                System.out.println("null");
                curr = leftMost.left;
                leftMost = leftMost.left;
            }else{
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);

        Node root = tree.getRoot();
//        populateRightNext(root);

//        traversingViaNext(root);
        populateRightNextTwo(root);
        traversingViaNextTwo(root);
    }
}
