package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinimumDepth {

    static int minDepth(Node root){
        if(root == null){
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                Node currNode = queue.poll();
                if(currNode.left == null && currNode.right == null){
                    return depth;
                }
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        BinaryTree.Node root = tree.getRoot();

        System.out.println("Maximum depth of the tree is: " + minDepth(root));
    }
}
