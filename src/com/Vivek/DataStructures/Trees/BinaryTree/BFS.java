package com.Vivek.DataStructures.Trees.BinaryTree;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.*;

public class BFS {
    static void levelOrder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.print(curr.value + " ");

            if(curr.left !=  null){
                queue.offer(curr.left);
            }
            if(curr.right != null){
                queue.offer(curr.right);
            }
        }
    }

    static List<List<Integer>> bfsSavingEachLevel(Node root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int currLevelSize = queue.size();
            List<Integer> currLevelValues = new ArrayList<>();

            for(int i = 0; i < currLevelSize; i++){
                Node currNode = queue.poll();
                currLevelValues.add(currNode.value);

                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            result.add(currLevelValues);
        }
        return result;
    }

    static void printLevelOrder(List<List<Integer>> levels){
        System.out.println();
        for(List<Integer> li : levels){
            System.out.println(li);
        }
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);

        Node root = tree.getRoot();
        levelOrder(root);

        List<List<Integer>> result = bfsSavingEachLevel(root);
        printLevelOrder(result);
    }
}
