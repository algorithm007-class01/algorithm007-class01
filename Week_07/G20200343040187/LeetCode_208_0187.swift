// 208. 实现 Trie (前缀树)
/*
 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

 示例:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // 返回 true
 trie.search("app");     // 返回 false
 trie.startsWith("app"); // 返回 true
 trie.insert("app");
 trie.search("app");     // 返回 true
 说明:

 你可以假设所有的输入都是由小写字母 a-z 构成的。
 保证所有输入均为非空字符串。
 */

class Trie {
    private var nodes: [Character: Trie]
    
    /** Initialize your data structure here. */
    init() {
        nodes = [:]
    }
    
    /** Inserts a word into the trie. */
    func insert(_ word: String) {
        var trie = self
        word.forEach {
            if let subTrie = trie.nodes[$0] {
                trie = subTrie
            } else {
                let subTrie = Trie()
                trie.nodes[$0] = subTrie
                trie = subTrie
            }
        }
        trie.nodes["#"] = Trie()
    }
    
    /** Returns if the word is in the trie. */
    func search(_ word: String) -> Bool {
        var trie = self
        for char in word {
            guard let subTrie = trie.nodes[char] else {
                return false
            }
            trie = subTrie
        }
        return trie.nodes["#"] != nil;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    func startsWith(_ prefix: String) -> Bool {
        var trie = self
        for char in prefix {
            guard let subTrie = trie.nodes[char] else {
                return false
            }
            trie = subTrie
        }
        return true
    }
}
