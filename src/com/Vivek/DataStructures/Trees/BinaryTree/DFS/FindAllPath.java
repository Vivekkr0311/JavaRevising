package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllPath {

//    public List<String> list = new ArrayList<>();
    static void helper(Node root, String path, List<String> list){
        if(root == null){
            return;
        }
        if(root.right == null && root.left == null){
            path = path + root.value;
            list.add(path);
            return;
        }

        String ans = path + root.value;
        helper(root.left,  ans + "->", list);
        helper(root.right, ans + "->", list);
    }

    static List<String> binaryTreePaths(Node root){
        List<String> list = new ArrayList<>();
        helper(root, "", list);
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        Node root = tree.getRoot();

        tree.preetyDisplay();
        System.out.println(binaryTreePaths(root));
    }
}
