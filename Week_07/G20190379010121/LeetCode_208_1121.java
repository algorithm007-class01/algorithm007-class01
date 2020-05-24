class Trie {
    private final int ALPHABET_SIZE = 26;
    private Trie[] children = new Trie[ALPHABET_SIZE];
    boolean isEndOfWord = false;
    public Trie() {}

    public void insert(String word) {
        Trie tmp = this;
        for (char i : word.toCharArray()) {
            if (tmp.children[i-'a'] == null) {
                tmp.children[i-'a'] = new Trie();
            }
            tmp = tmp.children[i-'a'];
        }
        tmp.isEndOfWord = true;
    }

    public boolean search(String word) {
        Trie tmp = this;
        for (char i : word.toCharArray()) {
            if (tmp.children[i-'a'] == null) {
                return false;
            }
            tmp = tmp.children[i-'a'];
        }
        return tmp.isEndOfWord ? true : false;
    }

    public boolean startsWith(String prefix) {
        Trie tmp = this;
        for (char i : prefix.toCharArray()) {
            if (tmp.children[i-'a'] == null) {
                return false;
            }
            tmp = tmp.children[i-'a'];
        }
        return true;
    }
}

作者：Guilong
        链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/jing-jian-javashi-xian-by-guilong/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。