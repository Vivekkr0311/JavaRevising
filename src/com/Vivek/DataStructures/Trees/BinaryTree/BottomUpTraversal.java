package com.Vivek.DataStructures.Trees.BinaryTree;

import java.util.*;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;

public class BottomUpTraversal {

    static void bottomUpTraversal(Node root){

        if(root == null){
            return;
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            stack.push(curr.value);

            if(curr.right != null){
                queue.offer(curr.right);
            }
            if(curr.left != null){
                queue.offer(curr.left);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    static List<List<Integer>> bottomUpTraversalTwo(Node root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){
                Node curr = queue.poll();
                level.add(curr.value);

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            result.add(0, level);
        }
        return result;
    }

    static void printResult(List<List<Integer>> result){
        for(List<Integer> li : result){
            System.out.println(li);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        bottomUpTraversal(root);
        printResult(bottomUpTraversalTwo(root));
    }
}
