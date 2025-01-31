package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree;

import java.util.*;

public class BinaryTree {

    public BinaryTree(){

    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        // Added this pointer to solve a question "Populating right next".
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public Node getRoot(){
        // Made this method to solve tree question in other java file,
        // its not good practice to return root node.
        // This is just for solving the question in different java file.
        return this.root;
    }


    public void populate(Scanner scanner){
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();
        root = new Node(value);

        populate(scanner, root);
    }

    private static void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter left of: " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value: ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right of: " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value: ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(this.root, "");
    }

    private void display(Node node, String indent){
        if(node == null){
            return;
        }

        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void preetyDisplay(){
        preetyDisplay(this.root, 0);
    }

    private void preetyDisplay(Node node, int level){
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
}
