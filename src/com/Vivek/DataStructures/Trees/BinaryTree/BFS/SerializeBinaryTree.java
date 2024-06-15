package com.Vivek.DataStructures.Trees.BinaryTree.BFS;

import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.*;

public class SerializeBinaryTree {

    static int height(Node root){
        if(root == null){
            return 0;
        }

        if(root != null && root.left == null && root.right == null){
            return 1;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static List<Integer> serialized(Node root){
        int height = height(root);

        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int currHeight = 0;
        while(!(currHeight >= height)){
            int currSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < currSize; i++){
                Node currNode = queue.poll();

                if(currNode != null){
                    currLevel.add(currNode.value);
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                }else{
                    currLevel.add(null);
                }
            }
            currHeight++;
            result.addAll(currLevel);
            System.out.println("Height" + currHeight + " : " + currLevel);
        }
        return result;
    }

    static Node deserialized(List<Integer> nodes){
//        for(int i = 0; i < nodes.size(); i++){
//            Node root = new Node(nodes.get(i));
//            root.left = new Node(nodes.get(2 * i + 1));
//            root.right = new Node(nodes.get(2 * i + 2));
//        }
//        return root;
        return null;
    }

    private static void preetyDisplay(Node node){
        preetyDisplay(node, 0);
    }

    private static void preetyDisplay(Node node, int level){
        if(node == null){
            return;
        }

        preetyDisplay(node.right, level + 1);

        if(level != 0){
            for(int i = 0; i < level - 1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|-------->" + node.value);
        }else{
            System.out.println(node.value);
        }
        preetyDisplay(node.left, level + 1);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();
        Node root = tree.getRoot();

        List<Integer> res = serialized(root);
        System.out.println("Serialized tree is: " + res);

        Node node = deserialized(res);
        preetyDisplay(node);
    }
}
