package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllPathFromRootToLeaf {

    static List<List<Integer>> paths = new ArrayList<>();
    static void helper2(Node root, int sum, List<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.value);

        if(root.value == sum && root.left == null && root.right == null){
            paths.add(new ArrayList<>(path));
        }else{
            helper2(root.left, sum - root.value, path);
            helper2(root.right, sum - root.value, path);
        }

        // backtrack
        path.remove(path.size() - 1);
    }

    static List<List<Integer>> pathSum(Node root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        helper2(root, targetSum, path);
        return paths;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        System.out.println("Enter the sum: ");
        int sum = scanner.nextInt();
        List<List<Integer>> paths = pathSum(root, sum);
        System.out.println("All paths are: " + paths);
    }
}
