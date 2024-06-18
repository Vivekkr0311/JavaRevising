package com.Vivek.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class SumRootToLeafNumbers {

    static ArrayList<String> helper(Node root, String str){
        if(root == null){
            ArrayList<String> li = new ArrayList<>();
            return li;
        }
        if(root.left == null && root.right == null){
            ArrayList<String> li = new ArrayList<>();
            str = str + root.value;
            li.add(str);
            return li;
        }

        String path = str + root.value;
        ArrayList<String> left = helper(root.left, path);
        ArrayList<String> right = helper(root.right, path);
        left.addAll(right);
        return left;
    }

    static int helper2(Node root, int sum){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            sum = sum * 10 + root.value;
            return sum;
        }

        int left = helper2(root.left, sum * 10 + root.value);
        int right = helper2(root.right, sum * 10 + root.value);
        return left + right;
    }

    static int sumNumbers(Node root){
        ArrayList<String> list = helper(root, "");
        System.out.println(list);
        int ans = 0;
        for(String str : list){
            ans = ans + Integer.parseInt(str);
        }
        return ans;
    }

    static int sumNumbersTwo(Node root){
        int ans = helper2(root, 0);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        System.out.println(sumNumbers(root));
        System.out.println(sumNumbersTwo(root));
    }
}
