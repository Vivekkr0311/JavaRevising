package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniqueBinarySearchTree {

    private static List<Node> helper(int start, int end){
        List<Node> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        if(start == end){
            list.add(new Node(start));
            return list;
        }

        for(int i = start; i <= end; i++){
            List<Node> leftTrees = helper(start, i - 1);
            List<Node> rightTrees = helper(i + 1, end);

            for(Node leftRoots : leftTrees){
                for(Node rightRoots : rightTrees){
                    Node root = new Node(i);
                    root.left = leftRoots;
                    root.right = rightRoots;
                    list.add(root);
                }
            }
        }
        return list;
    }

    private static List<Node> generate(int n){
        return helper(1, n);
    }

    private static void preetyDisplay(Node root){
        preetyDisplay(root, 0);
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
        System.out.println("Enter the number of nodes: ");
        int n = scanner.nextInt();

        List<Node> nodes = generate(n);
        for(Node roots : nodes){
            System.out.println("<=================>");
            preetyDisplay(roots);
        }
    }
}
