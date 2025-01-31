package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

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

    static Node selfTry(Node root){
        if(root == null){
            return null;
        }

        // horizontal pointer will traverse through level
        // and while traversing it will make the connections
        Node horizontal = root;
        Node leftTraverse = root;

        while(leftTraverse.left != null){
            horizontal = leftTraverse;

            while(horizontal != null){
                horizontal.left.next = horizontal.right;
                if(horizontal.next != null){
                    // This a special case when we will make connection of nodes which are siblings
                    // but there are not in the same subtree.

                    // for below example, think horizontal is at 2, and we are trying to
                    // make connection between 5 and 6

                    //         1  -> null
                    //       /   \
                    //      2  ->  3 -> null
                    //     /  \   / \
                    //    4 -> 5  6  7
                    horizontal.right.next = horizontal.next.left;
                }
                // horizontal will proceed in level
                horizontal = horizontal.next;
            }

            // left traverse pointer will proceed in left direction, it will
            // help horizontal pointer to come at left side, when horizontal hits the end of particular level.
            leftTraverse = leftTraverse.left;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);

        Node root = tree.getRoot();
//        populateRightNext(root);

//        traversingViaNext(root);
//        populateRightNextTwo(root);
        selfTry(root);
        traversingViaNextTwo(root);
    }
}
