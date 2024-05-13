package com.Vivek.DataStructures.Trees.AVL;

public class AVLRun {
    public static void main(String[] args) {
        AVL tree = new AVL();

        for(int i = 0; i < 10; i++){
            tree.insert(i);
        }

        tree.preetyDisplay();
    }
}
