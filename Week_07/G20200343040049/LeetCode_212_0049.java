class Solution {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    private Trie root;
    int row, col;
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        if (board.length == 0 || board[0].length == 0) return res;

        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        root = new Trie();

        for (String word : words) {
            root.insert(word);
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                recur(board, i, j, "", res);
            }
        }
        return res;
    }

    private void recur(char[][] board, int x, int y, String str, List<String> res) {
        if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y]) return;

        str += board[x][y];
        if (!root.startsWith(str)) return;
        if (root.search(str) && !res.contains(str)) res.add(str);

        visited[x][y] = true;
        for (int i = 0; i < 4; ++i) {
            recur(board, x + dx[i], y + dy[i], str, res);
        }
        visited[x][y] = false;
    }
}
class Trie {
    private Trie[] next;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return true;
    }
}
