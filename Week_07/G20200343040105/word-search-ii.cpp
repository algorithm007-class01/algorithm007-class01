//212. 单词搜索 II

class Solution {
public:
    struct TrieNode {
        vector<TrieNode*> next;
        string word;
        TrieNode() : word(""), next(vector<TrieNode*> (26, nullptr)) {}
    };

    TrieNode* buildTrie (vector<string>& words) {
        TrieNode* root = new TrieNode();
        for (string w : words) {
            TrieNode* curr = root;
            for (char c : w) {
                if (curr->next[c - 'a'] == NULL) 
                    curr->next[c - 'a'] = new TrieNode();
                curr = curr->next[c - 'a'];
            }    
            curr->word = w;
        }            
        return root;
    }

    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> out;
        TrieNode* root = buildTrie(words);
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[0].size(); ++j) {
                dfs(board, i, j, root, out);
            }
        }
        return out;
    }

    void dfs (vector<vector<char>>& board, int i, int j, TrieNode* curr, vector<string>& out) {
        char c = board[i][j];
        if (c == '#' || curr->next[c - 'a'] == NULL) return;
        curr = curr->next[c - 'a'];
        if (curr->word != "") {
            out.push_back(curr->word);
            curr->word = "";
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, curr, out);
        if (j > 0) dfs(board, i, j - 1, curr, out);
        if (i < board.size() - 1) dfs(board, i + 1, j, curr, out);
        if (j < board[0].size() - 1) dfs(board, i, j + 1, curr, out);
        board[i][j] = c;
    }
};