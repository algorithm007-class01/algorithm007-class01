package com.szp.leetcode.q201_250;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A212_word_search_ii {
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
                return new ArrayList<>();
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            int m = board.length;
            int n = board[0].length;
            Set<String> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int[][] visited = new int[m][n];
                    StringBuilder sb = new StringBuilder();
                    search(i, j, board, set, trie, visited, sb);
                    if (set.size() == words.length) {
                        break;
                    }
                }
            }
            return new ArrayList<>(set);
        }

        private void search(int x, int y, char[][] board, Set<String> set, Trie trie, int[][] visited, StringBuilder sb) {
            int[] a = {-1, 0, 1, 0};
            int[] b = {0, -1, 0, 1};
            int m = board.length;
            int n = board[0].length;

            visited[x][y] = 1;
            sb.append(board[x][y]);

            if (!trie.startsWith(sb.toString())) {
                return;
            }
            if (trie.search(sb.toString())) {
                set.add(sb.toString());
            }
            for (int k = 0; k < 4; k++) {// 10 -> 01
                int x1 = x + a[k];
                int y1 = y + b[k];

                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && visited[x1][y1] == 0) {
                    search(x1, y1, board, set, trie, visited, new StringBuilder(sb));
                    visited[x1][y1] = 0;
                }
            }
        }

        class Trie {
            class TrieNode {
                TrieNode[] nodes;
                char value;
                boolean isEnd = false;

                public TrieNode() {
                    nodes = new TrieNode[26];
                }

                public boolean containsKey(char ch) {
                    return nodes[ch - 'a'] != null;
                }

                public TrieNode get(char ch) {
                    return nodes[ch - 'a'];
                }

                public void put(char ch, TrieNode node) {
                    nodes[ch - 'a'] = node;
                }

                public void setEnd() {
                    isEnd = true;
                }

                public boolean isEnd() {
                    return isEnd;
                }
            }

            private TrieNode root;

            /**
             * Initialize your data structure here.
             */
            public Trie() {
                root = new TrieNode();
            }

            /**
             * Inserts a word into the trie.
             */
            public void insert(String word) {
                if (null == word || word.length() == 0)
                    return;
                TrieNode node = root;
                for (char ch : word.toCharArray()) {
                    if (!node.containsKey(ch)) {
                        TrieNode newNode = new TrieNode();
                        node.put(ch, newNode);
                    }
                    node = node.get(ch);
                }
                node.setEnd();
            }

            /**
             * Returns if the word is in the trie.
             */
            public boolean search(String word) {
                if (null == word || word.length() == 0)
                    return true;
                TrieNode node = root;
                for (char ch : word.toCharArray()) {
                    if (!node.containsKey(ch)) {
                        return false;
                    }
                    node = node.get(ch);
                }
                return node.isEnd;
            }

            /**
             * Returns if there is any word in the trie that starts with the given prefix.
             */
            public boolean startsWith(String prefix) {
                if (null == prefix || prefix.length() == 0)
                    return true;
                TrieNode node = root;
                for (char ch : prefix.toCharArray()) {
                    if (!node.containsKey(ch)) {
                        return false;
                    }
                    node = node.get(ch);
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new A212_word_search_ii().new Solution();
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        List<String> res = solution.findWords(board, words);
        System.out.println(res.size());
        res.stream().forEach(System.out::println);
    }


}
