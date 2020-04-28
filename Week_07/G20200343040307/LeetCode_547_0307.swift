/*
 * @lc app=leetcode.cn id=547 lang=swift
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
    func findCircleNum(_ M: [[Int]]) -> Int {
        var uni = [Int](repeating: 0, count: M.count)
        for i in 0..<uni.count {
            uni[i] = i
        }

        for y in 0..<M.count {
            for x in y..<M.count {
                if M[y][x] == 1{
                    union(x,y,&uni)
                }
            }
        }
        
        var count = 0
        for i in 0..<uni.count {
            if i == uni[i] {
                count += 1
            }
        }
        return count 
    }

    func find(_ m: Int, _ parent: [Int]) -> Int {
        var cur = m
        while cur != parent[cur] {
            cur = parent[cur]
        }
        return cur
    }

    func union(_ m: Int, _ n: Int, _ parent: inout [Int]) {
        let p1 = find(m, parent)
        let p2 = find(n, parent)
        if p1 != p2 {
            parent[p1] = p2
        }
    }
}
// @lc code=end

