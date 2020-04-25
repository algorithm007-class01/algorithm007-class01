//221. 最大正方形

//状态表示：dp[i][j] 以第ij位置为右下角的正方的最大边长
//状态计算：dp[i][j]=min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if (matrix.empty()) return 0;
        int m = matrix.size(), n = matrix[0].size(), res = 0;
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = min({dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]}) + 1;
                    res = max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
};