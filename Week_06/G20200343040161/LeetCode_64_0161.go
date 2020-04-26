package G20200343040161

//动态规划
func minPathSum(grid [][]int) int {
	m := len(grid)
	if m == 0 {
		return 0
	}
	n := len(grid[0])
	if n == 0 {
		return 0
	}
	//dp[i][j] 表示从0,0到最短路径和
	dp := make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)
	}
	dp[0][0] = grid[0][0] //第一个数的路径就是它本身
	//第一行上所有点的路径，就是前面的值相加
	for i := 1; i < m; i++ {
		dp[i][0] = dp[i-1][0] + grid[i][0]
	}
	//第一列上的所有点就是上面的值相加
	for j := 1; j < n; j++ {
		dp[0][j] = dp[0][j-1] + grid[0][j]
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			//第i,j个点可以从上面来，也可以从左边来，取决于哪个点的路径最短。再加上i,j的值
			dp[i][j] = getMin(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		}
	}

	return dp[m-1][n-1]
}

func getMin(a, b int) int {
	if a > b {
		return b
	}

	return a
}
