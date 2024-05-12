package com.Vivek.DataStructures.Trie;

public class Trie {

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;

        public void insert(String str, TrieNode root){
            TrieNode currNode = root;
            for(int i = 0; i < str.length(); i++){
                if(currNode.child[str.charAt(i) - 97] == null){
                    currNode.child[str.charAt(i) - 97] = new TrieNode();
                }
                currNode = currNode.child[str.charAt(i) - 97];
            }
            currNode.isEnd = true;
        }

        public boolean search(String str, TrieNode root){
            TrieNode childNode = root.child[str.charAt(0) - 97];
            for(int i = 1; i < str.length(); i++){
                if(childNode == null){
                    return false;
                }
                if(childNode != null){
                    childNode = childNode.child[str.charAt(i) - 97];
                }
            }
            return childNode.isEnd;
        }
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        String[] words = {"bad", "bat", "geek", "geeks", "cat", "cut", "zoo"};
        root.insert("bad", root);
        root.insert("bat", root);
        root.insert("geek", root);

        System.out.println(root.search("bad", root));
        System.out.println(root.search("bat", root));
        System.out.println(root.search("geek", root));
        System.out.println(root.search("abc", root));
    }
}
