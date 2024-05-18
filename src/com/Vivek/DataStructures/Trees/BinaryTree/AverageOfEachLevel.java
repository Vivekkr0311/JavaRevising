package com.Vivek.DataStructures.Trees.BinaryTree;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

public class AverageOfEachLevel {

    static List<Double> solution(Node root){
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        while(!queue.isEmpty()){

        }
        return result;
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);

        Node root = tree.getRoot();


    }
}
