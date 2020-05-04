/*
 * @lc app=leetcode.cn id=208 lang=csharp
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie () {
        root = new TrieNode ();
    }

    /** Inserts a word into the trie. */
    public void Insert (string word) {
        TrieNode node = root;
        for (int i = 0; i < word.Length; i++) {
            if (!node.ContainsKey (word[i])) {
                node.Put (word[i], new TrieNode ());
            }
            node = node.Get (word[i]);
        }
        node.SetEnd ();
    }

    /** Returns if the word is in the trie. */
    public bool Search (string word) {
        TrieNode node = searchPrefix (word);
        return node != null && node.IsEnd ();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public bool StartsWith (string prefix) {
        TrieNode node = searchPrefix (prefix);
        return node != null;
    }

    private TrieNode searchPrefix (string prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.Length; i++) {
            if (!node.ContainsKey (prefix[i])) return null;
            node = node.Get (prefix[i]);
        }
        return node;
    }
}

public class TrieNode {
    private TrieNode[] links;
    private const int R = 26;
    private bool isEnd = false;

    public TrieNode () {
        links = new TrieNode[R];
    }

    public bool ContainsKey (char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode Get (char ch) {
        return links[ch - 'a'];
    }

    public void Put (char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void SetEnd () {
        isEnd = true;
    }

    public bool IsEnd () {
        return isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */
// @lc code=end