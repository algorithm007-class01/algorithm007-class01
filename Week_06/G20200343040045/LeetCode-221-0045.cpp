#include <iostream>
#include <vector>
using namespace std;

/**
 * clarification:最大正方形
 * solution:
 *  DP状态方程为：
 *      matrix[i][j]==1的时候 dp[i][j]=dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
 *      边界条件：dp[1][1]开始计算
 * 
 * testcases 
*/
class Solution {
   public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int rows = matrix.size(), cols = rows > 0 ? matrix[0].size() : 0;
        vector<vector<int>> dp(rows + 1, vector<int>(cols + 1, 0));
        int ans = 0;
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    ans      = max(ans, dp[i][j]);
                }
            }
        }
        return ans * ans;
    }
};