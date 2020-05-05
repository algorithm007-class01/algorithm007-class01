//	Use the Union-Find algorithm to find the set connected to the boundary O, 
//	and then replace O that is not in this set with X.

class UnionFind {
public:
    UnionFind(int n) {
        count = n;
        parent = vector<int>(n, 0);
        rank = vector<int>(n, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }
    int find(int x) {
        int son = x;
        while (parent[x] != x) {
            x = parent[x];
        }
        while (son != x) {
            int tmp = parent[son];
            parent[son] = x;
            son = tmp;
        }
        return x;
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
    void solve(vector<vector<char>>& board) {
        if (board.size() == 0) return;
        int rows = board.size();
        int cols = board[0].size();
        //用一个虚拟节点将边界上的O联系起来，边界上的O的父节点都是这个虚拟节点
        int dummyNode = rows*cols;  
        UnionFind uf(dummyNode + 1);

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        uf.unionSet(i * cols + j, dummyNode);
                    } else {
                        if (i > 0 && board[i - 1][j] == 'O') {
                            uf.unionSet(i * cols + j, (i - 1) * cols + j);
                        }
                        if (i < rows - 1 && board[i + 1][j] == 'O') {
                            uf.unionSet(i * cols + j, (i + 1) * cols + j);
                        }
                        if (j > 0 && board[i][j - 1] == 'O') {
                            uf.unionSet(i * cols + j, i * cols + j - 1);
                        }
                        if (j < cols - 1 && board[i][j + 1] == 'O') {
                            uf.unionSet(i * cols + j, i * cols + j + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (board[i][j] == 'O' && !uf.isConnect(i * cols + j, dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
};