/*
 * @lc app=leetcode.cn id=200 lang=swift
 *
 * [200] 岛屿数量
 */

// @lc code=start
// 获取到 1 ，在获取到与 1 相邻的所有 1，循环查询
// 讲题去掉 1 变成 0 -》 已经 visited

// 问题一： 没有统一使用 ggg
// 问题二： 应该在获取到为“1”的新节点之后就将值赋值为“0”，也就是需要及时更新访问记录
class Solution {
    func numIslands(_ grid: [[Character]]) -> Int {
        var dx = [0,0,1,-1]
        var dy = [1,-1,0,0]
        var ggg = grid
        var stack = [(Int, Int)]()
        var land = 0
        for y in 0..<ggg.count {
            let row = ggg[y]
            for x in 0..<row.count {
                if ggg[y][x] == "1"{
                    land += 1
                    stack.append((x, y))
                    ggg[y][x] = "0"
                    while !stack.isEmpty {
                        let curr = stack.removeFirst()
                        
                        for i in 0...3 {
                            let newX = curr.0 + dx[i]
                            let newy = curr.1 + dy[i]
                            if newX >= 0 && newX < row.count && newy >= 0 && newy < grid.count  {
                                if ggg[newy][newX] == "1" {
                                    ggg[newy][newX] = "0"
                                    stack.append((newX,newy))
                                }
                            }
                        }
                    }
                }
            }
        }
        return land
    }
}

// DFS

class Solution {
    func numIslands(_ grid: [[Character]]) -> Int {
        var ggg = grid
        var ans = 0
        for y in 0..<ggg.count {
            let row = ggg[y]
            for x in 0..<row.count {
                    if ggg[y][x] == "1"{
                        ans += 1
                        helper(x,y,&ggg)
                    }
            }
        }
        return ans
    }
    func helper(_ x: Int, _ y: Int, _ ggg: inout [[Character]]) {
        if x < 0 || y < 0 || y >= ggg.count || x >= ggg[0].count || ggg[y][x] == "0" {
            return 
        }
        ggg[y][x] = "0"
        helper(x-1,y,&ggg)
        helper(x+1,y,&ggg)
        helper(x,y+1,&ggg)
        helper(x,y-1,&ggg)
    }
}
// @lc code=end

