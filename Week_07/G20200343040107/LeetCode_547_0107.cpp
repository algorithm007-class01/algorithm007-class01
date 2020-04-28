#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int getParent_(vector<int>& relation_map, int v) {
        int parent_node = relation_map[v];
        if (parent_node == v) {
            return parent_node;
        }

        relation_map[v] = getParent_(relation_map, parent_node);

        return relation_map[v];
    }

    int findCircleNum(vector<vector<int>>& M)
    {
        int n = M.size();
        vector<int> relation_map(n, 0);
        for (int i = 0; i < n; ++i) {
            relation_map[i] = i;
        }

        for (int i = 0; i < M.size(); ++i) {
            for (int j = 0; j < M[i].size(); ++j) {
                if (i != j && M[i][j] == 1) {
                    int root_i = getParent_(relation_map, i);
                    int root_j = getParent_(relation_map, j);
                    if (root_i != root_j) {
                        relation_map[root_j] = root_i;
                    }
                }
            }
        }

        int num_of_group = 0;
        for (int i = 0; i < n; ++i) {
            if (relation_map[i] == i) {
                ++num_of_group;
            }
        }

        return num_of_group;
    }
};


int main(int argc, char* argv[]) {
	return 0;
}