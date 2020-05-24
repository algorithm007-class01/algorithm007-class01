//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchIi_212 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        if (null == board || board.length == 0 || board[0].length == 0 || null == words || words.length == 0) {
            return new ArrayList<>(0);
        }

        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        Set<String> r = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (trie.startsWith(board[i][j])) {
                    findWords(board, i, j, "", trie, new HashSet<>(), r);
                }
            }
        }
        return new ArrayList<>(r);
    }
    private void findWords(char[][] board, int i, int j, String prefix, Trie trie, Set<String> set, Set<String> r) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        String id = i + "," + j;
        if (set.contains(id)) {
            return;
        }
        set.add(id);

        String word = prefix + board[i][j];
        if (trie.search(word)) {
            r.add(word);
        }

        if (trie.startsWith(word)) {
            findWords(board, i - 1, j, word, trie, set, r);
            findWords(board, i + 1, j, word, trie, set, r);
            findWords(board, i, j - 1, word, trie, set, r);
            findWords(board, i, j + 1, word, trie, set, r);
        }

        set.remove(id);
    }

    // 暴力破解法（超时）
    public List<String> findWords1(char[][] board, String[] words) {
        if (null == board || board.length == 0 || board[0].length == 0 || null == words || words.length == 0) {
            return new ArrayList<>(0);
        }

        List<String> r = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (findWords(board, words[i].toCharArray())) {
                r.add(words[i]);
            }
        }
        return r;
    }
    private boolean findWords(char[][] board, char[] chars) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (findWords(board, i, j, chars, 0, new HashSet<>(64))) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean findWords(char[][] board, int i, int j, char[] chars, int index, Set<String> set) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != chars[index]) {
            return false;
        }

        String id = i + "," + j;
        if (set.contains(id)) {
            return false;
        }
        set.add(id);

        if (index == chars.length - 1) {
            return true;
        }

        int nextIndex = index + 1;
        if (findWords(board, i - 1, j, chars, nextIndex, set)) {
            return true;
        }
        if (findWords(board, i + 1, j, chars, nextIndex, set)) {
            return true;
        }
        if (findWords(board, i, j - 1, chars, nextIndex, set)) {
            return true;
        }
        if (findWords(board, i, j + 1, chars, nextIndex, set)) {
            return true;
        }

        set.remove(id);

        return false;
    }
}

class Trie {

    public static final int CHAR_COUNT = 26;

    private final TrieNode[] roots;

    public Trie() {
        TrieNode[] roots = new TrieNode[CHAR_COUNT];
        for (int i = 0; i < CHAR_COUNT; i++) {
            roots[i] = new TrieNode();
        }
        this.roots = roots;
    }

    public void insert(String word) {
        checkString(word);

        char[] chars = word.toCharArray();
        roots[chars[0] - 'a'].resolve(chars, 0);
    }

    public boolean search(String word) {
        checkString(word);

        char[] chars = word.toCharArray();
        return roots[chars[0] - 'a'].search(chars, 0);
    }

    public boolean startsWith(String prefix) {
        checkString(prefix);

        char[] chars = prefix.toCharArray();
        return roots[chars[0] - 'a'].startsWith(chars, 0);
    }

    public boolean startsWith(char ch) {
        TrieNode root = roots[ch - 'a'];
        return root.count > 0 || root.children != null;
    }

    private void checkString(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    class TrieNode {

        private int count;
        private TrieNode[] children;

        public void resolve(char[] chars, int index) {
            if (index == chars.length - 1) {
                count++;
                return;
            }

            if (children == null) {
                children = new TrieNode[CHAR_COUNT];
            }

            int childCharIndex = index + 1;
            int childIndex = chars[childCharIndex] - 'a';
            TrieNode child = children[childIndex];
            if (child == null) {
                child = new TrieNode();
                children[childIndex] = child;
            }
            child.resolve(chars, childCharIndex);
        }

        public boolean search(char[] chars, int index) {
            if (index == chars.length - 1) {
                return count > 0;
            }

            if (children == null) {
                return false;
            }

            int childCharIndex = index + 1;
            TrieNode child = children[chars[childCharIndex] - 'a'];
            if (child == null) {
                return false;
            }

            return child.search(chars, childCharIndex);
        }

        public boolean startsWith(char[] chars, int index) {
            if (index == chars.length - 1) {
                return count > 0 || null != children;
            }

            if (children == null) {
                return false;
            }

            int childCharIndex = index + 1;
            TrieNode child = children[chars[childCharIndex] - 'a'];
            if (child == null) {
                return false;
            }

            return child.startsWith(chars, childCharIndex);
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
  