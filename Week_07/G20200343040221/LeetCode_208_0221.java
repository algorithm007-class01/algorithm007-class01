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

package leetcode.editor.cn;

public class ImplementTriePrefixTree_208 {
    
//leetcode submit region begin(Prohibit modification and deletion)
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
  