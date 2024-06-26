package com.Vivek.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountCompleteTreeNodesUsingBFS {
    
    // Its DFS solution is much faster

    private static int countNodes(Node root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int currSum = 0;
        while(!queue.isEmpty()){

            int currSize = queue.size();
            currSum += currSize;
            for(int i = 0; i < currSize; i++){
                Node curr = queue.poll();

                if(curr.right != null){
                    queue.add(curr.right);
                }

                if(curr.left != null){
                    queue.add(curr.left);
                }
            }
        }
        return currSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        System.out.println("Number of nodes: " + countNodes(root));
    }
}
