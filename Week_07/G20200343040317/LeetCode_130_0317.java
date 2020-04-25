class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) {
            return;
        }
        int col = board[0].length;
        if (col == 0) {
            return;
        }
        int dumy = row * col;
        final UnionFind uf = new UnionFind(dumy+1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int p = i * col + j;
                if (board[i][j] == 'O') {
                    // 处理边缘
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        uf.union(p, dumy);
                    }

                    if (i > 0 && board[i - 1][j] == 'O') {
                        uf.union(p, p - col);
                    }

                    if (i < row - 1 && board[i + 1][j] == 'O') {
                        uf.union(p, p + col);
                    }
                    if (j > 0 && board[i][j - 1] == 'O') {
                        uf.union(p, p - 1);
                    }
                    if (j < col - 1 && board[i][j + 1] == 'O') {
                        uf.union(p, p + 1);
                    }
                }

            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!uf.isConnected(dumy,i*col+j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            int p1 = p;
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            while (parent[p1] != p) {
                p1 = parent[p1];
                parent[p1] = p;
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
            }
        }
        
        public boolean isConnected(int p ,int q) {
            return find(p) == find(q);
        }
    }


}