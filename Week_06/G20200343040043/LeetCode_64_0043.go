package G20200343040043

// 64. 最小路径和
// 题目：https://leetcode-cn.com/problems/minimum-path-sum/

// 解法
// 两层遍历，当前节点最小值=min([i-1][j], [i][j-1])+cur,注意边界

func minPathSum(grid [][]int) int {
	var maxI, maxJ int
	for i, vList := range grid {
		maxI = i
		for j := range vList {
			maxJ = j
			if i > 0 && j > 0 {
				grid[i][j] += min(grid[i-1][j], grid[i][j-1])
			} else if i > 0 {
				grid[i][j] += grid[i-1][j]
			} else if j > 0 {
				grid[i][j] += grid[i][j-1]
			}
		}
	}
	return grid[maxI][maxJ]

}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

// times: 1
