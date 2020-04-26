#include <vector>
#include <iostream>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if (grid.size() == 0 || grid[0].size() == 0) {
            return 0;
        }

        int row = grid.size();
        int col = grid[0].size();
        vector<long> tmp(col, grid[0][0]);
        vector<vector<long>> dp_res(row, tmp);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int val_i = i > 0 ? dp_res[i - 1][j] : INT_MAX;
                int val_j = j > 0 ? dp_res[i][j - 1] : INT_MAX;
                dp_res[i][j] = min(val_i, val_j) + grid[i][j];
            }
        }
        return dp_res.back().back();
    }
};


int main(int argc, char* argv[]) {
    vector<vector<int>> grid = {{1,3,1},{1,5,1},{4,2,1}};
    Solution sol;
    cout << sol.minPathSum(grid) << endl;
    return 0;
}