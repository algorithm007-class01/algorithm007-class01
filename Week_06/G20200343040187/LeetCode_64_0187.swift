// 64. 最小路径和
/*
 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

 说明：每次只能向下或者向右移动一步。

 示例:

 输入:
 [
   [1,3,1],
   [1,5,1],
   [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。
 */

class Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {
        guard grid.count != 0 && grid[0].count != 0 else{
            return 0
        }
    
        let m = grid.count, n = grid[0].count
        var dp = Array(repeating: Array(repeating: 0, count: n), count: m)
        
        for i in 0..<m {
            for j in 0..<n {
                if i == 0 && j == 0{
                    dp[i][j] = grid[i][j]
                } else if i == 0 {
                    dp[i][j] = dp[i][j - 1] + grid[i][j]
                } else if j == 0 {
                    dp[i][j] = dp[i - 1][j] + grid[i][j]
                } else {
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j]
                }
            }
        }
        
        return dp[m - 1][n - 1]
    }
}

