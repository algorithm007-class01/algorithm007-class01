/*
 * @lc app=leetcode.cn id=22 lang=swift
 *
 * [22] 括号生成
 */

// @lc code=start
// 迭代
class Solution {
    func generateParenthesis(_ n: Int) -> [String] {
        var ans = [String]()
        var stack = [(String, Int, Int)]()
        stack.append(("",0,0))
        while !stack.isEmpty {
            let tuple = stack.removeFirst()
            if tuple.0.count == n*2 {
                ans.append(tuple.0)
                continue
            }

            if tuple.1 < n{
                stack.append((tuple.0 + "(" , tuple.1 + 1, tuple.2))
            }

            if tuple.2 < tuple.1 && tuple.1 > 0  {
                stack.append((tuple.0 + ")" , tuple.1, tuple.2 + 1))
            }
        }
        return ans
    }
}

// DFS
class Solution {
    func generateParenthesis(_ n: Int) -> [String] {
        var ans = [String]()
        dfs(0,0,n,"",&ans)
        return ans
    }

    func dfs(_ left: Int, _ right: Int, _ n: Int, _ list:  String, _ ans: inout [String]) {
        if left >= n && right >= n {
            ans.append(list)
            return 
        }

        if left < n {
            dfs(left+1,right,n,list+"(",&ans)
        }
        if right < left {
            dfs(left,right+1,n,list+")",&ans)
        }
    }
}
// @lc code=end

