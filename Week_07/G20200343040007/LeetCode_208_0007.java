//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    Node head;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        head = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node curr = head;
        char[] c = word.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if (curr.nodes[c[i] - 'a'] == null) curr.nodes[c[i] - 'a'] = new Node();
            curr = curr.nodes[c[i] - 'a'];
        }
        curr.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node curr = searchNode(word);
        return curr != null && curr.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private Node searchNode(String word) {
        Node curr = head;
        char[] c = word.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if (curr.nodes[c[i] - 'a'] == null) return null;
            curr = curr.nodes[c[i] - 'a'];
        }
        return curr;
    }

    private class Node {
        boolean end;
        Node[] nodes;

        public Node() {
            end = false;
            nodes = new Node[26];
        }
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
