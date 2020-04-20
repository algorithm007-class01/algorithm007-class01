package leetcode_week04_G20200343040053

//【200. 岛屿数量】

//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

//leetcode submit region begin(Prohibit modification and deletion)
func numIslands(grid [][]byte) int {
	ret := 0
	if len(grid) == 0 || len(grid[0]) == 0 {
		return ret
	}
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				ret++
				clearNearby(grid, i, j)
			}
		}
	}
	return ret
}

func clearNearby(grid [][]byte, i int, j int) {
	if i < 0 || j < 0 || i >= len(grid) || j >= len(grid[0]) || grid[i][j] != '1' {
		return
	}
	grid[i][j] = '0'
	clearNearby(grid, i-1, j)
	clearNearby(grid, i+1, j)
	clearNearby(grid, i, j-1)
	clearNearby(grid, i, j+1)
}

//leetcode submit region end(Prohibit modification and deletion)
