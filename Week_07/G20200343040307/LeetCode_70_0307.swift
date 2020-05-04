/*
 * @lc app=leetcode.cn id=70 lang=swift
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    // DP
    func climbStairs(_ n: Int) -> Int {
            if n == 1 {
                return 1
            }
            if n == 2 {
                return 2
            }
            var first = 1
            var second = 2
            var count = n
            while count <= 3 {
                count -= 1
                let third = first + second
                first = second
                second = third
            }
            return second
    }
    // DP improve 
    func climbStairs(_ n: Int) -> Int {
        var a = 1
        var b = 1 
        var count = n
        while count > 0 {
            b += a
            a = b - a
            count -= 1
        } 
        return a
    }

    // DFS 
    func climbStairs(_ n: Int) -> Int {
        var cache = [Int](repeating: 0, count: n+1)
        return dfs(n,&cache)
    }

    func dfs( _ level : Int, _ cache: inout [Int]) -> Int {
        if level < 0 {
            return 0
        } 
        if level < 3 {
            return level
        }

        if cache[level] != 0 {
            return  cache[level]
        }

        cache[level] = dfs(level-1, &cache) + dfs(level-2, &cache)
        return cache[level]
    }

}
// @lc code=end

