package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import java.util.*;

public class ConvertSortedArrayToBinarySearchTree {

    // Use case of preorder DFS traversal

    static Node helper(int[] arr, int start, int end){
        if(arr.length == 0){
            return null;
        }
        if(start > end){
            return null;
        }
        if(start == end){
            Node newNode = new Node(arr[end]);
            return newNode;
        }
        int mid = Math.ceilDiv(start + end, 2);
        Node newNode = new Node(arr[mid]);
        newNode.left = helper(arr, start, mid - 1);
        newNode.right = helper(arr, mid + 1, end);
        return newNode;
    }

    static Node convert(int[] arr){
        if(arr.length == 0){
            return null;
        }

        return helper(arr, 0, arr.length - 1);
    }

    static void traverse(Node node){
        if(node == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int currLevelSize = queue.size();
            List<Integer> currlevel = new ArrayList<>();

            for(int i = 0; i < currLevelSize; i++){
                Node currNode = queue.poll();
                currlevel.add(currNode.value);

                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            System.out.println(currlevel);
        }
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
        System.out.println("Number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements of your sorted array: ");
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        Node root = convert(arr);
        traverse(root);
        preetyDisplay(root);
    }
}
