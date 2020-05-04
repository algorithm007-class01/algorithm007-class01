public class LeetCode_208_0147 {

    class Trie {

        private TireNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TireNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TireNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TireNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TireNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TireNode cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }

        private class TireNode {
            private TireNode[] children = new TireNode[26];
            private boolean isWord;
        }
    }
}
