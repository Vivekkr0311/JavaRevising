package com.Vivek.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Deque;
import java.util.List;

public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        boolean flag = false;

        while(!deque.isEmpty()){
            int currLevelSize= deque.size();
            List<Integer> currLevel = new ArrayList<>();

            for(int i = 0; i < currLevelSize; i++){
                if(flag){
                    Node currNode = deque.pollLast();
                    currLevel.add(currNode.valueue);

                    if(currNode.right != null){
                        deque.addFirst(currNode.right);
                    }
                    if(currNode.left != null){
                        deque.addFirst(currNode.left);
                    }
                }else{

                    Node currNode = deque.pollFirst();
                    currLevel.add(currNode.value);

                    if(currNode.left != null){
                        deque.addLast(currNode.left);
                    }
                    if(currNode.right != null){
                        deque.addLast(currNode.right);
                    }
                }
            }
            result.add(currLevel);
            flag = !flag;
        }
        return result;
    }

    static void zigZag(Node root){
        if(root == null){
            return;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);

        boolean level = false;
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            for(int i = 0; i < levelSize; i++){

                if(level){
                    Node curr = deque.pollFirst();
                    System.out.print(curr.value + " ");

                    if(curr.left != null){
                        deque.addLast(curr.left);
                    }

                    if(curr.right != null){
                        deque.addLast(curr.right);
                    }

                }else{
                    Node curr = deque.pollLast();
                    System.out.print(curr.value + " ");

                    if(curr.right != null){
                        deque.addFirst(curr.right);
                    }

                    if(curr.left != null){
                        deque.addFirst(curr.left);
                    }
                }
            }
            level = !level;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        zigZag(root);
    }
}
