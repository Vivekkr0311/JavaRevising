package com.Vivek.LeetCode.DataStructures.Trie.HashTrie;

import java.util.Hashtable;

public class TrieNode {
    Hashtable<Character, TrieNode> childdren = new Hashtable<>();

    boolean isEndOfWord;

    TrieNode(){
        this.isEndOfWord = false;
    }
}
