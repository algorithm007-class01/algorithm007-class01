/*
 * @lc app=leetcode.cn id=63 lang=swift
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    func uniquePathsWithObstacles(_ obstacleGrid: [[Int]]) -> Int {
        if obstacleGrid.count == 0 || obstacleGrid[0].count == 0 || obstacleGrid[0][0] == 1{
            return 0
        }
        var ans = [[Int]](repeating: [Int](repeating: 0, count: obstacleGrid[0].count), count: obstacleGrid.count)
        ans[0][0] = 1
        for i in 1..<obstacleGrid.count {
            if ans[i-1][0] != 0 && obstacleGrid[i][0] != 1 {
                ans[i][0] = 1
            }
        }

        for j in 1..<obstacleGrid[0].count {
            if ans[0][j-1] != 0 && obstacleGrid[0][j] != 1 {
                ans[0][j] = 1
            }
        }
        
        for y in 1..<ans.count {
            for x in 1..<ans[0].count {
                if obstacleGrid[y][x] == 1 {
                    ans[y][x] = 0
                }else{
                    ans[y][x] = ans[y-1][x] + ans[y][x-1]
                }
            }
        }

        return ans.last!.last!
    }
}



// improve 

class Solution {
    func uniquePathsWithObstacles(_ obstacleGrid: [[Int]]) -> Int {
        let m = obstacleGrid.count
        let n = obstacleGrid[0].count
        
        var dp = [[Int]](repeatElement([Int](repeatElement(0, count: n + 1)), count: m + 1))
        
        dp[0][1] = 1
        for i in 1...m {
            for j in 1...n {
                if obstacleGrid[i - 1][j - 1] != 1 {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }
        
        return dp[m][n]
    }
}


func uniquePathsWithObstacles_SlidingWindow(_ obstacleGrid: [[Int]]) -> Int {
        let n = obstacleGrid[0].count
        var dp = [Int](repeatElement(0, count: n))
        
        dp[0] = 1
        for row in obstacleGrid {
            for i in 0..<n {
                if row[i] == 1 {
                    dp[i] = 0
                } else if i > 0 {
                    dp[i] += dp[i - 1]
                }
            }
        }
        
        return dp[n - 1]
    }


递归 - 核心代码（超出时间限制）
      public int dfs(int[][] obstacleGrid ,int row,int col){
    // System.out.println(row);
        if(row >= obstacleGrid.length || col >= obstacleGrid[0].length || obstacleGrid[row][col] == 1  )
            return 0;
        if(row == obstacleGrid.length-1 && col == obstacleGrid[0].length-1)
            return 1;
        return dfs(obstacleGrid,row+1,col) + dfs(obstacleGrid,row,col+1);    
    }
// @lc code=end

