class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        final UnionFile uf = new UnionFile(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                int p = i * col + j;
                // 前一列
                if (j - 1 > 0 && grid[i][j - 1] == '1') {
                    uf.union(p, p - 1);
                }
                // 后一列
                if (j + 1 < col && grid[i][j + 1] == '1') {
                    uf.union(p, p + 1);
                }
                // 上一行
                if (i - 1 > 0 && grid[i - 1][j] == '1') {
                    uf.union(p, p - col);
                }
                // 下一行
                if (i + 1 < row && grid[i + 1][j] == '1') {
                    uf.union(p, p + col);
                }
            }
        }
        return uf.getCount();
    }

    static class UnionFile {

        private int[] parent;
        int count = 0;

        public UnionFile(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int len = row * col;
            this.parent = new int[len];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                    }
                }
            }
            for (int i = 0; i < len; i++) {
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
                count--;
            }
        }

        public int getCount() {
            return count;
        }

    }
}