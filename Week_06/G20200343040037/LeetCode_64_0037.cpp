class Solution{
	public:
		int minPathSum(vector<vector<int>>& grid) {
			// 1 暴力
			// dp
			// a 分治 f[i,j]= min{subproblem(向下),subproblem(向右)} + 当前节点.
			// b 状态数组 dp[m+1][n-1]
			//   b.1 初始化状态数组 1->m f[i,0] = f[i-1,0] + grid[i,0]; 1->n f[0,i] = f[0, i-1] + grid[0,i]
			// c dp方程
			int m = grid.size();
			int n = grid[0].size();
			// 状态数组
			vector<vector<int>> dp(m + 1, vector<int>(n + 1, grid[0][0]);
			// 初始化状态数组 
			for(int i = 1; i < m; i++) {
				dp[i][0] = dp[i - 1][0] + grid[i][0];
			}
			for(int j = 1; j < n; j++) {
				dp[0][j] = dp[0][j - 1] + grid[0][j];
			}
			// 定义dp
			for(int i = 1; i < m; i++) {
				for(int j = 1; j < n; j++) {
					dp[i][j] = min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
				}
			}
			return dp[m - 1][n - 1];
		}
};
