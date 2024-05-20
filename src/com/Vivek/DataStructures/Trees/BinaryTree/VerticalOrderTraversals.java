package com.Vivek.DataStructures.Trees.BinaryTree;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.*;

public class VerticalOrderTraversals {

    static void verticalOrderTraversal(Node node, int horizontalDistance, HashMap<Integer, List<Integer>> table){
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

    static void printResult(HashMap<Integer, List<Integer>> table){
        for(Map.Entry<Integer, List<Integer>> record : table.entrySet()){
            System.out.println("At vertical line " + record.getKey() + " -> " + record.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        HashMap<Integer, List<Integer>> table = new HashMap<>();
        verticalOrderTraversal(root, 0, table);
        printResult(table);
    }
}
