class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}

class UnionFind {
    private int count;
    private int[] parent;

    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];

        for (int i = 0; i < n; ++i) {
            parent[i] =  i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            // 路径压缩，让该节点的parent指向其祖父节点
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = this.find(p);
        int rootQ = this.find(q);

        if (rootP == rootQ) return;
        parent[rootQ] = rootP;
        count--;
    }

    public int getCount() {
        return count;
    }
}