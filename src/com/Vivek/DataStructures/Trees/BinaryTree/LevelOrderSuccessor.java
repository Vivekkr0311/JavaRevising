package com.Vivek.DataStructures.Trees.BinaryTree;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderSuccessor {

    static int levelOrderSuccessor(Node root, int val){
        if(root == null){
            return -1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node currNode = queue.poll();

            if(currNode.left != null){
                queue.offer(currNode.left);
            }
            if(currNode.right != null){
                queue.offer(currNode.right);
            }

            if(currNode.value == val){
                break;
            }
        }
        
        return queue.peek() == null ? -1 : queue.peek().value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        Node root = tree.getRoot();
        tree.preetyDisplay();

        System.out.println("Enter whose level order successor you wanna find: ");
        int val = scanner.nextInt();

        System.out.println(levelOrderSuccessor(root, val));
    }
}
