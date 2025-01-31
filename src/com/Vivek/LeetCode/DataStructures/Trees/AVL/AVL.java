package com.Vivek.LeetCode.DataStructures.Trees.AVL;

public class AVL {
    // Balanced tree: For every node of a tree, h(left sub tree) - h(right sub tree) should be either -1, 0 or 1 only.
    // where h(n) is function to calculate height for the given node pointer 'n'.

    // AVL tree: Purpose of AVL trees is to balance unbalanced binary search trees. AVL trees are self-balancing binary trees.
    // Adelson - Velsky and Landis

    // 1. Insert node 'n' normally
    // 2. Start from node 'n' and find the node that makes the tree unbalanced, bottom-up
    // 3. Using one of the 4 rules, rotate.

    // '4' Rules

    // Left-Left (LL) Case: This case occurs when a node's left subtree is higher by two levels than its right subtree,
    // and the new node is inserted into the left subtree of the left child of the unbalanced node.
    // To rebalance, a single right rotation is performed on the unbalanced node.

    // Right-Right (RR) Case: This case is the mirror image of the LL case. I
    // t occurs when a node's right subtree is higher by two levels than its left subtree,
    // and the new node is inserted into the right subtree of the right child of the unbalanced node.
    // To rebalance, a single left rotation is performed on the unbalanced node.

    // Left-Right (LR) Case: This case occurs when a node's left subtree is higher by two levels than its right subtree,
    // and the new node is inserted into the right subtree of the left child of the unbalanced node.
    // To rebalance, a left rotation is performed on the left child followed by a right rotation on the unbalanced node.

    // Right-Left (RL) Case: This case is the mirror image of the LR case.
    // It occurs when a node's right subtree is higher by two levels than its left subtree,
    // and the new node is inserted into the left subtree of the right child of the unbalanced node.
    // To rebalance, a right rotation is performed on the right child followed by a left rotation on the unbalanced node.

    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    public AVL(){

    }

    private Node root;

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void display(){
        display(this.root, "Root node: ");
    }

    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + ":");
        display(node.right, "Right child of " + node.value + ":");
    }

    public void preetyDisplay(){
        preetyDisplay(this.root, 0);
    }

    private void preetyDisplay(Node node, int level){
        if(node == null){
            return;
        }

        preetyDisplay(node.right, level + 1);

        if(level != 0){
            for(int i = 0; i < level - 1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------(" + node.value + ")");
        }else{
            System.out.println("(" + node.value + ")");
        }
        preetyDisplay(node.left, level + 1);
    }

    public void populateSorted(int[] nums){
        // T(n) = O(n * log(n))
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int mid = start + (end - start) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    public void insert(int value){
        // T(n) = O(log(n))
        this.root = insert(value, this.root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(value, node.left);
        }

        if(value > node.value){
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node){
        if(height(node.left) - height(node.right) > 1){
            // left heavy
            if(height(node.left.left) - height(node.left.right) > 0 ){
                // left left case
                return rightRotate(node);
            }

            if(height(node.left.left) - height(node.left.right) < 0 ){
//          left right case

//                    p
//              (L) /   \
//                  c   t4
//                 / \ (R)
//                t1  gc
//                   /  \
//                  t2    t3

                node.left = leftRotate(node.left);
//              After Left rotation on 'c'
//                     p
//                (L) / \
//                  gc   t4
//             (L) /  \
//                c    t3
//               / \
//              t1 t2
                return rightRotate(node);

//              After Right rotation on 'p'
//                     gc
//                   /     \
//                  c       p
//                /  \    /  \
//              t1    t2  t3  t4
            }
        }

        if(height(node.left) - height(node.right) < -1){
            // right heavy
            if(height(node.right.left) - height(node.right.right) < 0 ){
                // right right case
                return leftRotate(node);
            }

            if(height(node.right.left) - height(node.right.right) > 0 ) {
//              Right Left case
//                            p
//                           / \ (R)
//                          t1   c
//                         (L) /   \
//                            gc    t4
//                            /  \
//                           t2   t3

                node.right = rightRotate(node.right);
//                After right rotation on 'c'
//                            p
//                           / \ (L)
//                          t1   gc
//                             /   \ (L)
//                            t2    c
//                                 /  \
//                                t2   t3
                return leftRotate(node);

//                After left rotation on 'p'
//                           gc
//                          / \
//                         p    c
//                       /  \   /   \
//                    t2   t3   t3   t4
            }
        }
        return node;
    }

    private Node rightRotate(Node p){
//        p                                                     c
// (L)   / \                                                /      \
//      c   t4                                             gc       p
// (L) / \        After Right Rotation on 'c' =>         /   \    /   \
//    gc  t3                                            t1   t2  t3    t4
//   /  \
//  t1   t2

        Node c = p.left;
        Node t3 = c.right;
        c.right = p;
        p.left = t3;

        p.height = Math.max(height(p.left), height(p.right) + 1) ;
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }

    private Node leftRotate(Node c){
//        p                                                    c
//       / \  (R)                                           /      \
//      t1   c                                             p        gc
//          /  \ (R) After Left Rotation on 'c' =>       /   \    /   \
//         t2   gc                                      t1   t2  t3    t4
//             /  \
//            t3   t4
//     Another example: This example can be used to relate with the code.
//        c                                                   p
//      /   \ (R)                                           /   \
//     t1    p     After Left Rotation on 'c' =>           c      t3
//          /  \ (R)                                      /  \
//         t2   t2                                       t1    t2

        Node p = c.right;
        Node t2 = p.left;

        p.left = c;
        c.right = t2;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }

    public boolean balanced(){
        return balanced(this.root);
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1
                &&
                balanced(node.right) && balanced(node.left);
    }

    public void populate(int[] nums){
        for(int i = 0; i < nums.length; i++){
            this.insert(nums[i]);
        }
    }

    public void preorderTraversal(){
        preOrder(this.root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inorderTraversal(){
        inOrder(this.root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postTraversal(){
        postOrder(this.root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
}
