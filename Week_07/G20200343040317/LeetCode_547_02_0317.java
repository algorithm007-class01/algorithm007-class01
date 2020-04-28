class Solution {
    public int findCircleNum(int[][] M) {
        final UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i; j < M.length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    static class UnionFind {
        int[] parent;
        int count = 0;

        public UnionFind(int n) {
            this.parent = new int[n];
            count = n;
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
            // 压缩路径
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
                count--;
            }
            parent[rootP] = rootQ;

        }

        public int getCount() {
            return count;
        }
    }
}