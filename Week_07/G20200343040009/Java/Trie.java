/**
 * LeetCode208
 * 实现前缀树
 */
public class Trie {
    private class TreeNode {
        private boolean isEnd;
        private TreeNode[] next;

        public TreeNode() {
            isEnd = false;
            next = new TreeNode[26];
        }
    }

    private TreeNode root;

    public Trie() {
        this.root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int currChar = word.charAt(i) - 'a';
            if (node.next[currChar] == null) {
                node.next[currChar] = new TreeNode();
            }
            node = node.next[currChar];
        }
        // 标记为是一个单词
        node.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int currChar = word.charAt(i) - 'a';
            if (node.next[currChar] == null) {
                return false;
            }
            node = node.next[currChar];
        }
        return node.isEnd;
    }

    public boolean startWith(String prefix) {
        TreeNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int currChar = prefix.charAt(i) - 'a';
            if (node.next[currChar] == null) {
                return false;
            }
            node = node.next[currChar];
        }
        return true;
    }
}
