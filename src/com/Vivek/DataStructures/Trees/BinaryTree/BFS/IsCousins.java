package com.Vivek.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.Scanner;

public class IsCousins {

    static boolean isSiblings(Node node, Node ff, Node ss){
        if(node == null){
            return false;
        }

        return ((node.left == ff) && (node.right == ss)) || ((node.left == ss) && (node.right == ff)) ||
                isSiblings(node.right, ff, ss) || isSiblings(node.left, ff, ss);
    }

    static int level(Node root, Node node, int level){
        if(root == null){
            return 0;
        }

        if(root == node){
            return level;
        }
        int leftSide = level(root.left, node, level + 1);
        if(leftSide != 0){
            return leftSide;
        }
        return level(root.right, node, level +1 );
    }

    static Node findNode(Node root, int number){
        if(root == null){
            return null;
        }

        if(root.value == number){
            return root;
        }
        Node leftNode = findNode(root.left, number);
        if(leftNode != null){
            return leftNode;
        }
        return findNode(root.right, number);
    }

    static boolean isCousins(Node root, int f, int s){
        if(root == null){
            return false;
        }
        Node ff = findNode(root, f);
        Node ss = findNode(root, s);

        System.out.println(ff.value + " " + ss.value);
        return (level(root, ff, 0) == level(root, ss, 0) && (!isSiblings(root, ff, ss)));
    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        BinaryTree tree =  new BinaryTree();
        tree.populate(scanner);
        Node root = tree.getRoot();

        tree.preetyDisplay();
        System.out.println("Enter first cousin: ");
        int f =  scanner.nextInt();
        System.out.println("Enter second cousin: ");
        int s = scanner.nextInt();

        System.out.printf(f + " and " + s + " are cousins: " + isCousins(root, f, s));
    }
}
