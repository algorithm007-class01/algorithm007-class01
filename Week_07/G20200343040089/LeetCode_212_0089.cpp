//	Match words with the same word group and character board, return the matching sequence
//	Example:
//		Solution sol;
//		vector<string> res = sol.findWords(board, words);
//		retuurn res;

class TrieNode {
public:
    bool isWord;
    string word;
    unordered_map<char, TrieNode*> words;
    TrieNode() {
        isWord = false;
    }
};
class Trie {
public:
    Trie() {
        root = new TrieNode();
    }
    void insert(string word) {
        TrieNode *node = root;
        for (char c : word) {
            if (node->words.find(c) == node->words.end()) {
                TrieNode *tmp = new TrieNode();
                node->words[c] = tmp;
            }
            node = node->words[c];
        }
        // node对应的word，为了之后根据node来只好到结果
        node->word = word;  
        node->isWord = true;
    }
    void search(vector<string>& res, vector<vector<char>>& board) {
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[i].size(); ++j) {
                DFS(res, board, root, i, j);
            }
        }
    }
    void DFS(vector<string>& res, vector<vector<char>>& board, TrieNode *node, int x, int y) {
        if (node->isWord) {
            node->isWord = false;   // 其他方向就不会在把答案放进去了
            res.push_back(node->word);
            return ;
        }
        if (x < 0 || x == board.size() || y < 0 || y == board[x].size()) return;
        if (node->words.find(board[x][y]) == node->words.end()) return ;

        node = node->words[board[x][y]];
        char cur = board[x][y];
        board[x][y] = '#';
        for (int i = 0; i < 4; ++i) {
            DFS(res, board, node, x + dx[i], y + dy[i]);
        }
        board[x][y] = cur;
    }
private:
    TrieNode *root;
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
};

class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        Trie *trie = new Trie();
        vector<string> res;

        for (string str : words) {
            trie->insert(str);
        }
        trie->search(res, board);
        return res;
    }
};