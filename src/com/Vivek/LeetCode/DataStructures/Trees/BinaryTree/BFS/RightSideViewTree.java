package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.*;

public class RightSideViewTree {

    static List<Integer> rightSideViewTwo(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                Node curr = queue.poll();
                if(i == levelSize - 1){
                    result.add(curr.value);
                }

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        Node root = tree.getRoot();
        tree.preetyDisplay();

        System.out.println(rightSideViewTwo(root));

    }
}
