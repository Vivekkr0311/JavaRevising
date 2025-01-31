package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree.Node;
import com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.BinaryTree;

import java.util.*;

public class SerializeAndDeserializeTree {

    static String serialize(Node node){
        String ans = "";
        ans = helper(node, ans);
        return ans;
    }

    static String helper(Node node, String ans){
        if(node == null){
            ans = ans + "null,";
            return ans;
        }

        ans = ans + String.valueOf(node.value) + ",";
        ans = helper(node.left, ans);
        ans = helper(node.right, ans);
        return ans;
    }

    static Node deserialize(String stream){
        List<String> list = new ArrayList<>(List.of(stream.split(",")));
        Collections.reverse(list);
        Node node = helper2(list);
        return node;
    }

    static Node helper2(List<String> list){
        String val = list.remove(list.size() - 1);
        if(val.charAt(0) == 'n'){
            return null;
        }

        Node node = new Node(Integer.parseInt(val));
        node.left = helper2(list);
        node.right = helper2(list);
        return node;
    }

    static void preetyDisplay(Node node){
        preetyDisplay(node, 0);
    }

    static void preetyDisplay(Node node, int level){
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
        String ans = serialize(root);
        System.out.println("Serialized: " + ans);
        Node root2 = deserialize(ans);
        preetyDisplay(root2);
    }
}
