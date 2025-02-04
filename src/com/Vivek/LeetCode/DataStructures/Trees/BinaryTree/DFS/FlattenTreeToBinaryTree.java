package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import java.util.*;

import java.util.Scanner;

public class FlattenTreeToBinaryTree {

    static Deque<Node> deque = new LinkedList<>();
    static Node node = null;
    static void convert(Node root){
        Node curr = root;
        if(curr == null){
            return;
        }
        deque.offer(curr);
        convert(root.left);
        convert(root.right);
    }

    static Node solution(){
        node = new Node(deque.pollFirst().value);
        Node temp = node;
        while(!deque.isEmpty()){
            temp.right = new Node(deque.pollFirst().value);
            temp = temp.right;
        }
        return node;
    }

    static void flatten(Node root){
        if(root == null){
            return;
        }

        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                Node temp = curr.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    private static void preetyDisplay(Node node){
        preetyDisplay(node, 0);
    }

    private static void preetyDisplay(Node node, int level){
        if(node == null){
            return;
        }

        preetyDisplay(node.right, level + 1);

        if(level != 0){
            for(int i = 0; i < level - 1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|-------->" + node.value);
        }else{
            System.out.println(node.value);
        }
        preetyDisplay(node.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        System.out.println("Converting: ");
//        convert(root);
//        preetyDisplay(solution());

        flatten(root);
        tree.preetyDisplay();
    }
}
