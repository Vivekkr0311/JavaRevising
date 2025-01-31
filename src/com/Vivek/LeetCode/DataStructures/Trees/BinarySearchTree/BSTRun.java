package com.Vivek.LeetCode.DataStructures.Trees.BinarySearchTree;

public class BSTRun {
    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
        tree.populate(nums);
        tree.display();
        System.out.println("-------------------------");
        tree.preetyDisplay();

        System.out.println("Sorted array tree: ");
        int[] sorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        BST treeTwo = new BST();
        treeTwo.populateSorted(sorted);
        treeTwo.preetyDisplay();

        System.out.print("Preorder: ");
        treeTwo.preorderTraversal();
        System.out.println();
        System.out.print("Inorder: ");
        treeTwo.inorderTraversal();
        System.out.println();
        System.out.print("Postorder: ");
        treeTwo.postTraversal();
    }
}
