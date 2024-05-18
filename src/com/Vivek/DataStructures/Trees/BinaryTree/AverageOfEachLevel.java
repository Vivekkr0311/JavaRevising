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
        queue.offer(root);

        while(!queue.isEmpty()){
            int currLevelSize = queue.size();
            Double currAvg = 0.0;

            for(int i = 0; i < currLevelSize; i++){
                Node currNode = queue.poll();
                currAvg += (double) currNode.value;

                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            result.add(currAvg / currLevelSize);
        }
        return result;
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);

        Node root = tree.getRoot();
        List<Double> result = solution(root);
        System.out.println(result);
    }
}
