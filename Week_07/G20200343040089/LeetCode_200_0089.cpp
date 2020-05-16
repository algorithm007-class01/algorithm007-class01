//	Use Union-find algorithm to find the number of islands. 
//	The connected islands are essentially a set, which can be combined for calculation
class UnionFind {
public:
    UnionFind(int n) {
        count = n;
        parent = vector<int>(n, 0);
        rank = vector<int>(n, 0);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }
    int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    void unionSet(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ; 
        } else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootQ]++;
            }
        }
        count--;
    }
    bool isConnect(int p, int q) {
        return find(p) == find(q);
    }
    int getCount(void) {
        return count;
    }
private:
    int count = 0;
    vector<int> parent;
    vector<int> rank;
};
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size() == 0) return 0;
        int row = grid.size();
        int col = grid[0].size();
        int size = row * col;
        UnionFind uf(size + 1);
        int dx[2] = {1, 0};
        int dy[2] = {0, 1};

        for (int i = 0; i < row; ++i) 
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == '0') {
                    uf.unionSet(i*col+j, size); //如果是水域，都连接到一个虚拟空间
                } else {
                    for (int k = 0; k < 2; ++k) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < row && y < col && grid[x][y] == '1') {
                            uf.unionSet(i*col+j, x*col+y);
                        }
                    }
                }
            }
        return uf.getCount() - 1;
    }
};