package com.Vivek.CustomDataStructures.Trie.HashTrie;

public class HashTrie {
    private TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode curr = root;

        for(char ch :  word.toCharArray()){
            curr.childdren.putIfAbsent(ch, new TrieNode());
            curr = curr.childdren.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode node = getNode(word);
        return node != null && node.isEndOfWord;
    }

    public boolean searchPrefix(String word){
        return getNode(word) !=  null;
    }

    private TrieNode getNode(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.childdren.containsKey(ch)){
                return null;
            }
            curr = curr.childdren.get(ch);
        }
        return curr;
    }
}
