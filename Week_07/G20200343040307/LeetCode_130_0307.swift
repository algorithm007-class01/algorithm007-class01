/*
 * @lc app=leetcode.cn id=130 lang=swift
 *
 * [130] 被围绕的区域
 */

// @lc code=start
// 并查集解法
// 错误在二维数组转换成一维数组时的公式
class Solution {
    func solve(_ board: inout [[Character]]) {
        if board.count == 0 || board[0].count == 0{
            return 
        }
        let m = board.count
        let n = board[0].count
        var parent = [Int]()
        for y in 0..<m {
            for x in 0..<n {
                let index = y*n+x
                parent.append(index)
            }
        }
        parent.append(m*n)
        for y in 0..<m {
            for x in 0..<n {
                if board[y][x] == "O" {
                    if x == 0 || x == n-1 || y == 0 || y == m-1 {
                        union(y*n+x, m*n, &parent)
                    }else  {
                        for item in [(1,0),(-1,0),(0,1),(0,-1)] {
                            let newX = x+item.0
                            let newY = y+item.1
                            if 0 <= newX && newX < n && 0 <= newY && newY < m {
                                if board[newY][newX] == "O" {
                                    union(y*n+x, newY*n+newX, &parent)
                                }
                            }
                        }
                    }
                } 
            }
        }
        // print("\(parent)")
        for y in 0..<m {
            for x in 0..<n {
                // print("\(find(y*n+x, parent))+\(find(m*n, parent))")
                if find(y*n+x, &parent) != find(m*n,&parent) {
                    board[y][x] = "X"
                }
            }
        }
    }

    func union(_ x: Int, _ y: Int, _ parent: inout [Int]) {
        let rootx = find(x, &parent)
        let rooty = find(y, &parent)
        if rootx != rooty {
            parent[rooty] = rootx
        }
    }

    func find(_ n: Int,_ parent: inout [Int]) -> Int {
        var cur = n
        while cur != parent[cur] {
            cur = parent[cur]
        }
        var i = n
        while i != parent[i] {
            let x = parent[i]
            parent[i] = cur
            i = x
        }
        return cur
    }
}
// @lc code=end

