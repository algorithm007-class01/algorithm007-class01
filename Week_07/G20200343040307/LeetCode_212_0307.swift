/*
 * @lc app=leetcode.cn id=212 lang=swift
 *
 * [212] 单词搜索 II
 */

// @lc code=start
// 以每个点为中心四连通判断是否有单词符合这个前缀
// 符合则继续四连通判断，直到四个方向都不成立
// 
class Solution {
    func findWords(_ board: [[Character]], _ words: [String]) -> [String] {
        if board.count == 0 || board[0].count == 0{
            return []
        }
        var trie = Trie()
        for word in words {
            trie.insert(word)
        }
        var ans = [String]()
        var visited = Array(repeating: Array(repeating: false, count: board[0].count), count: board.count)
        func dfs(_ x: Int, _ y: Int,_ pre: String, _ current: TrieNode, _ board: [[Character]]) {
            if x < 0 || x >= board[0].count || y < 0 || y >= board.count || visited[y][x] == true {
                return
            }
            // print("\(x)+\(y)")
            if current.endWord == true && !ans.contains(pre){
                ans.append(pre)
            }

            visited[y][x] = true
            if y > 0{
                if let ch = current.children[board[y-1][x]] {
                    dfs(x,y-1,pre+"\(board[y-1][x])",ch,board)
                }
            }
            
            if x > 0{
                if let ch = current.children[board[y][x-1]] {
                    dfs(x-1,y,pre+"\(board[y][x-1])",ch,board)
                }
            }

            if y < board.count - 1{
                if let ch = current.children[board[y+1][x]] {
                    dfs(x,y+1,pre+"\(board[y+1][x])",ch,board)
                }
            }
            if x < board[0].count - 1 {
                if let ch = current.children[board[y][x+1]] {
                    dfs(x+1,y,pre+"\(board[y][x+1])",ch,board)
                }
            }

            visited[y][x] = false
        }

        for y in 0..<board.count {
            for x in 0..<board[0].count {
                if let ch = trie.root.children[board[y][x]] {
                    dfs(x,y,"\(board[y][x])",ch,board)
                }
            }
        }
        return ans
    }

}



class Trie {
    var root: TrieNode
    /** Initialize your data structure here. */
    init() {
        root = TrieNode()
    }
    
    /** Inserts a word into the trie. */
    func insert(_ word: String) {
        var curr = root
        for ch in word {
            var node = curr.children[ch]
            if node == nil {
                node = TrieNode()
                curr.children[ch] = node
            }
            curr = node!
        }
        curr.endWord = true
    }
    
    /** Returns if the word is in the trie. */
    func search(_ word: String) -> Bool {
        var curr = root
        for ch in word {
            let node = curr.children[ch]
            if node == nil {
                return false
            }
            curr = node!
        }
        return curr.endWord
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    func startsWith(_ prefix: String) -> Bool {
        var curr = root 
        for ch in prefix {
            let node = curr.children[ch]
            if node == nil {
                return false
            }
            curr = node!
        }
        return true
    }
}

class TrieNode {
    var children: [Character: TrieNode]
    var endWord: Bool
    init() {
        self.children = [Character: TrieNode]()
        self.endWord = false
    }
}
// @lc code=end

