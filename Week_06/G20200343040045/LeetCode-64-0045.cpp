#include <iostream>
#include <vector>
using namespace std;

/**
 * clarification:最小路径和
 * solution:
 *  1. 使用正向递推，计算row==0和col==0的边界情况，其他的用状态转移方程dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j]
 *  2. 使用逆向地推,从右下角开始往前递推，递推上一个向右和向下的最小路径和
 * 
 * testcases 
*/
class Solution {
   public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> sum(m, vector<int>(n, grid[0][0]));
        for (int i = 1; i < m; ++i) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        return sum[m - 1][n - 1];
    }
};