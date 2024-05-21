package com.Vivek.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.*;

public class VerticalOrderTraversals {

    static void verticalOrderTraversal(Node node, int horizontalDistance, TreeMap<Integer, List<Integer>> table){
        if(node == null){
            return;
        }
        if(table.containsKey(horizontalDistance)){
            table.get(horizontalDistance).add(node.value);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(node.value);
            table.put(horizontalDistance, list);
        }
        verticalOrderTraversal(node.left, horizontalDistance - 1, table);
        verticalOrderTraversal(node.right, horizontalDistance + 1, table);
    }

    static void printResult(TreeMap<Integer, List<Integer>> table){
        for(Map.Entry<Integer, List<Integer>> record : table.entrySet()){
            System.out.println(record.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        TreeMap<Integer, List<Integer>> table = new TreeMap<>();
        verticalOrderTraversal(root, 0, table);
        printResult(table);
    }
}
