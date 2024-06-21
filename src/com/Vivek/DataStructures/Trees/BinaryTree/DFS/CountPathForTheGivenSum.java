package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class CountPathForTheGivenSum {

    static int countPath(Node root, int sum){
        if(root == null){
            return 0;
        }
        return helper(root, sum, new ArrayList<>());
    }

    static List<List<Integer>> findPath(Node root, int sum){
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper2(root, sum, path, paths);
        return paths;
    }

    static int helper(Node root, int sum, ArrayList<Integer> path){
        if(root == null){
            return 0;
        }

        path.add(root.value);
        int count = 0;
        int s = 0;

        // How many paths I can make
        ListIterator<Integer> itr = path.listIterator(path.size());

        while(itr.hasPrevious()){
            s += itr.previous();
            if(s == sum){
                count++;
            }
        }

        count += helper(root.left, sum, path) + helper(root.right, sum, path);

        // backtrack

        path.remove(path.size() - 1);
        return count;
    }

    static void helper2(Node root, int sum, List<Integer> path, List<List<Integer>> paths){
        if(root == null){
            return;
        }

        path.add(root.value);

        if(root.value == sum && root.left == null && root.right == null){
            paths.add(new ArrayList<>());
        }else{
            helper2(root.left, sum - root.value, path, paths);
            helper2(root.right, sum - root.value, path, paths);
        }

        // backtrack
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        System.out.println("Enter the sum: ");
        int sum = scanner.nextInt();

        System.out.println("Number of path exist for the sum: " + sum + " is " + countPath(root, sum));
        System.out.println("All path exist for the sum: " + sum + " is ");
        List<List<Integer>> result = findPath(root, sum);
        for(List<Integer> li : result){
            System.out.println(li);
        }
    }
}
