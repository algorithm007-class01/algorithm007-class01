/*
 * @lc app=leetcode.cn id=64 lang=swift
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {
        if grid.count == 0 || grid[0].count == 0 {
            return 0
        }
        var ans = grid
        for y in 0..<grid.count {
            for x in 0..<grid[0].count {
                if x == 0 && y == 0{
                    continue
                }else if y == 0{
                    ans[y][x] = ans[y][x-1] + ans[y][x]
                }else if x == 0 {
                    ans[y][x] = ans[y][x] + ans[y-1][x]
                }else{
                    ans[y][x] = min(ans[y-1][x], ans[y][x-1]) + ans[y][x]
                }
            }
        }
        print("\(ans)")
        return ans.last!.last!
    }
}

- 一维数组

class Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {
        if grid.count == 0 || grid[0].count == 0 {
            return 0
        }
        var ans = [grid[0][0]]
        for item in 1..<grid[0].count {
            ans.append(ans.last!+grid[0][item])
        }
        for i in 1..<grid.count {
            for j in 0..<ans.count {
                if j == 0 {
                    ans[j] += grid[i][j]
                }else{
                    ans[j] = min(ans[j-1], ans[j]) + grid[i][j]
                }
            }
            print("\(ans)")
        }
        
        return ans.last!
    }
}
// @lc code=end

