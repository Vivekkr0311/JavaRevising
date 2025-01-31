package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;

import java.util.*;


public class RecoverBSTTwoNodesSwapped {

    static ArrayList<Node> list = new ArrayList<>();
    static void makeArr(Node root){
        if(root == null){
            return;
        }

        makeArr(root.left);
        list.add(root);
        makeArr(root.right);
    }

    static void recoverTree(Node root){
        if(root == null){
            return;
        }

        makeArr(root);
        ArrayList<Node> list2 = new ArrayList<>();
        list2.addAll(list);
        list.sort((a, b) -> Integer.compare(a.value, b.value));

        int first = -1;
        int second = -1;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != list2.get(i) && first == -1){
                first = i;
            }else if(list.get(i) != list2.get(i) && first != -1){
                second = i;
                break;
            }
        }

        int temp = list2.get(first).value;
        list2.get(first).value = list2.get(second).value;
        list2.get(second).value = temp;
    }

    static void print(ArrayList<Node> list){
        for(Node node : list){
            System.out.print(node.value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.preetyDisplay();

        Node root = tree.getRoot();
        System.out.println("Recovering: ");
        recoverTree(root);
        tree.preetyDisplay();
    }
}
