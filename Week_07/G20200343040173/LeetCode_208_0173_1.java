/**
 * 208. 实现 Trie (前缀树)
 * 
 */

// Trie 树的结点结构
class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node)  {
        links[ch - 'a'] = node;
    }

    public void setEnd()  {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 时间复杂度：O(m)，其中 m 为键长。
    // 空间复杂度：O(m)，最坏的情况下，新插入的键和 Trie 树中已有的键没有公共前缀。
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (!node.containsKey(curChar)) {
                node.put(curChar, new TrieNode());
            }
            node = node.get(curChar);
        }
        node.setEnd();
    }

    // 时间复杂度：O(m)。
    // 空间复杂度：O(1)。
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // 时间复杂度：O(m)。
    // 空间复杂度：O(1)。
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i <  word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }
}