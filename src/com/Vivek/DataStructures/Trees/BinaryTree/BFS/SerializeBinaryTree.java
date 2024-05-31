package com.Vivek.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.*;

public class SerializeBinaryTree {

    static int height(Node root){
        if(root == null){
            return 0;
        }

        if(root != null && root.left == null && root.right == null){
            return 1;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static List<Integer> serialized(Node root){
        int height = height(root);

        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int currHeight = 0;
        while(!(currHeight >= height)){
            int currSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < currSize; i++){
                Node currNode = queue.poll();

                if(currNode != null){
                    currLevel.add(currNode.value);
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                }else{
                    currLevel.add(null);
                }
            }
            currHeight++;
            result.addAll(currLevel);
            System.out.println("Height" + currHeight + " : " + currLevel);
        }
        return result;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        Node root = tree.getRoot();

        System.out.println("Serialized tree is: " + serialized(root));
    }
}
