package com.Vivek.LeetCode.DataStructures.Trees.BinarySearchTree;

import java.util.Scanner;

public class BST {
    public static class Node {
        public int value;
        public int height;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    public BST(){

    }

    private Node root;

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void display(){
        display(this.root, "Root node: ");
    }

    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + ":");
        display(node.right, "Right child of " + node.value + ":");
    }

    public void preetyDisplay(){
        preetyDisplay(this.root, 0);
    }

    private void preetyDisplay(BST.Node node, int level){
        if(node == null){
            return;
        }

        preetyDisplay(node.right, level + 1);

        if(level != 0){
            for(int i = 0; i < level - 1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------(" + node.value + ")");
        }else{
            System.out.println("(" + node.value + ")");
        }
        preetyDisplay(node.left, level + 1);
    }

    public void populateSorted(int[] nums){
        // T(n) = O(n * log(n))
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int mid = start + (end - start) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    public void insert(int value){
        // T(n) = O(log(n))
        this.root = insert(value, this.root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(value, node.left);
        }

        if(value > node.value){
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean balanced(){
        return balanced(this.root);
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1
                &&
                balanced(node.right) && balanced(node.left);
    }

    public void populate(int[] nums){
        for(int i = 0; i < nums.length; i++){
            this.insert(nums[i]);
        }
    }

    public void preorderTraversal(){
        preOrder(this.root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inorderTraversal(){
        inOrder(this.root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postTraversal(){
        postOrder(this.root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

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
}
