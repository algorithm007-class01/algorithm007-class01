class UnionFind {
public:
    UnionFind(int n):count_(n) {
        parent_.reserve(n);
        rank_.reserve(n);
        for(int i = 0; i < n; i++) {
            parent_[i] = i;
        }
    }

    int UF_find(int p) {
        while(p != parent_[p]) {
            parent_[p] = parent_[parent_[p]];
            p = parent_[p];
        }
        return p;
    }
    void UF_union(int p, int q) {
        int rootP = UF_find(p);
        int rootQ = UF_find(q);
        if(rootP == rootQ) {
            return;
        }
        if(rank_[rootQ] > rank_[rootP] ) {
            parent_[rootP] = rootQ;
        } else {
            parent_[rootQ] = rootP;
            if(rank_[rootQ] == rank_[rootP]) {
                rank_[rootP]++;
            }
        }
        count_--;
    }

    int UF_count() {
        return count_;
    }

private:
    int count_;
    vector<int> parent_, rank_;
};

class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        /*
        第一种方法：DFS
        if tree.root is None:
            return 0;
        visited, stack = [], [tree.root]
        while stack:
           node = stack.pop()
           visited.add(node)

           process(node)
           nodes = generate_related_nodes(node)
           stack.push(nodes)
        */
        /*int size = M.size();
        vector<bool> visited(size, false);
        int count = 0;
        for(int i = 0; i < size; i++) {
            if(!visited[i]) {
                findCircleNum(M, visited, i);
                count++;
            }
        }
        return count;*/

        /*
        使用并查集,
        */

        int size = M.size();
        UnionFind uf(size);
        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                if(M[i][j] == 1) {
                    uf.UF_union(i, j);
                }
            }
        }
        return uf.UF_count();
    }

    void findCircleNum(vector<vector<int>>& M, vector<bool>& visited, int index) {
        for(int i = 0; i < M.size(); i++) {
            if(M[index][i] == 1 && !visited[i]) {
                visited[i] = 1;
                findCircleNum(M, visited, i);
            }
        }
    }


};
