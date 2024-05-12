package com.Vivek.DataStructures.Trie.HashTrie;

public class Main {
    public static void main(String[] args) {
        HashTrie hashTrie = new HashTrie();
        hashTrie.insert("apple");

        System.out.println(hashTrie.search("apple"));
        System.out.println(hashTrie.searchPrefix("app"));
        System.out.println(hashTrie.search("app"));

        hashTrie.insert("app");
        System.out.println(hashTrie.search("app"));
    }
}
