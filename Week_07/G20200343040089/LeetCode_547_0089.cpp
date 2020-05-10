//	Use the Union-Find algorithm to merge subsets to calculate the number of friend circles
class UnionFind {
public:
    UnionFind(int n) {
        count = n;
        parents = vector<int>(n, 0);
        rank = vector<int>(n, 0);
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }
    }

    int find(int x) {
        int son = x;
        while (parents[x] != x) {
            x = parents[x];
        }
        while (son != x) {
            int tmp = parents[son];
            parents[son] = x;
            son = tmp;
        }
        return x;
    } 

    void unionSet(int x, int y) {
        int xroot = find(x);
        int yroot = find(y);
        if (xroot == yroot) return;
        
        if (rank[xroot] > rank[yroot]) {
            parents[yroot] = xroot;
        } else {
            parents[xroot] = yroot;
            if (rank[xroot] == rank[yroot]) {
                rank[xroot]++;
            }
        }
        count--;
    }

    int getCount(void) {
        return count;
    }
private:
    int count = 0;
    vector<int> parents;
    vector<int> rank;
};
class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        if (M.size() == 0) return 0;
        int n = M.size();
        UnionFind uf(n);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (M[i][j] == 1) {
                    uf.unionSet(i, j);
                }
            }
        }
        return uf.getCount();
    }
};