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