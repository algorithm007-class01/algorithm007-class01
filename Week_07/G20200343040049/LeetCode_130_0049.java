class Solution {
    int m, n;
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        m = board.length;
        n = board[0].length;

        UnionFind uf = new UnionFind(m*n + 1);
        int dummyNode = m*n;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] != 'O') continue;
                boolean isEdge = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                if (isEdge) {
                    uf.union(node(i, j), dummyNode);
                } else {
                    for (int k = 0; k < 4; ++k) {
                        int newx = i + dx[k], newy = j + dy[k];
                        if (isValid(newx,newy) && board[newx][newy] == 'O') {
                            uf.union(node(newx, newy), node(i, j));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && !uf.isConnected(node(i, j), dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public boolean isValid(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return false;
        return true;
    }

    public int node(int x, int y) {
        return x * n + y;
    }
}

class UnionFind {
    private int count;
    private int[] parent;

    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];

        for (int i = 0; i < n; ++i)
            parent[i] = i;
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        if (isConnected(p, q)) return;
        parent[find(p)] = find(q);
        count--;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}