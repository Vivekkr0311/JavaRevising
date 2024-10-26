package com.Vivek.DataStructures.Trees.BinarySearchTree;

import com.Vivek.DataStructures.Trees.BinarySearchTree.BST.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FindModeOfABinarySearchTree {

    private static int max = 0;
    private static void helper(Node root, HashMap<Integer, Integer> map){
        if(root == null){
            return;
        }

        if(map.containsKey(root.value)){
            map.put(root.value, map.get(root.value) + 1);
        }else{
            map.put(root.value, 1);
        }

        max = Math.max(max, map.get(root.value));
        helper(root.left, map);
        helper(root.right, map);
    }

    private static int[] findMode(Node root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        System.out.println(map);
        ArrayList<Integer> list = new ArrayList<>();

        for(Integer key : map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }

        int[] res = new int[list.size()];
        int idx = 0;
        for(Integer i : list){
            res[idx++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST bst = new BST();
        bst.populate(scanner);
        Node root = bst.getRoot();
        bst.preetyDisplay();

        System.out.println(Arrays.toString(findMode(root)));
    }
}
