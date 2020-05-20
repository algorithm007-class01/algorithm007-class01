package com.szp.leetcode.q201_250;

public class A208_implement_trie_prefix_tree {

    class Trie {
        class TrieNode{
            TrieNode[] nodes;
            char value;
            boolean isEnd = false;
            public TrieNode(){
                nodes = new TrieNode[26];
            }
            public boolean containsKey(char ch){
                return nodes[ch-'a'] != null;
            }
            public TrieNode get(char ch){
                return nodes[ch-'a'];
            }
            public void put(char ch, TrieNode node){
                nodes[ch - 'a'] = node;
            }
            public void setEnd(){
                isEnd = true;
            }
            public boolean isEnd(){
                return isEnd;
            }
        }
        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if(null == word || word.length() == 0)
                return;
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                if(!node.containsKey(ch)){
                    TrieNode newNode = new TrieNode();
                    node.put(ch,newNode);
                }
                node = node.get(ch);
            }
            node.setEnd();
        }
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if(null == word || word.length() == 0)
                return true;
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                if(!node.containsKey(ch)){
                    return false;
                }
                node = node.get(ch);
            }
            return node.isEnd;
        }
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if(null == prefix || prefix.length() == 0)
                return true;
            TrieNode node = root;
            for(char ch : prefix.toCharArray()){
                if(!node.containsKey(ch)){
                    return false;
                }
                node = node.get(ch);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new A208_implement_trie_prefix_tree().new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); //true
        System.out.println(trie.search("app"));//false
        System.out.println(trie.startsWith("app"));//true
        trie.insert("app");
        System.out.println(trie.search("app"));//true
    }
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
