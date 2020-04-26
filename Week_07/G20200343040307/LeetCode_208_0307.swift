/*
 * @lc app=leetcode.cn id=208 lang=swift
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start


class Trie {
    var root: TrieNode
    /** Initialize your data structure here. */
    init() {
        self.root = TrieNode()
    }
    
    /** Inserts a word into the trie. */
    func insert(_ word: String) {
        var cur = root
        for ch in word {
            var node = cur.children[ch]
            if node == nil {
                node = TrieNode()
                cur.children[ch] = node
            }
            cur = node!
        }
        cur.endWord = true
    }
    
    /** Returns if the word is in the trie. */
    func search(_ word: String) -> Bool {
        var cur = root
        for ch in word {
            let node = cur.children[ch]
            if node == nil {
                return false
            }
            cur = node!
        }
        return cur.endWord
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    func startsWith(_ prefix: String) -> Bool {
        var cur = root
        for ch in prefix {
            let node = cur.children[ch]
            if node == nil {
                return false
            }
            cur = node!
        }
        return true
    }
}

class TrieNode {
    var endWord: Bool
    var children: [Character: TrieNode]
    init () {
        self.endWord = false
        self.children = [Character: TrieNode]()
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * let obj = Trie()
 * obj.insert(word)
 * let ret_2: Bool = obj.search(word)
 * let ret_3: Bool = obj.startsWith(prefix)
 */
// @lc code=end

