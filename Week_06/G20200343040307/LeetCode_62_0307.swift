/*
 * @lc app=leetcode.cn id=62 lang=swift
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    func uniquePaths(_ m: Int, _ n: Int) -> Int {
        var ans = [[Int]](repeating: [Int](repeating: 1, count: m), count: n)
        for y in 1..<n {
            for x in 1..<m {
                ans[y][x] = ans[y-1][x] + ans[y][x-1]
            }
        }
        return ans[n-1][m-1]
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
}

class Solution {
    func uniquePaths(_ m: Int, _ n: Int) -> Int {
        var ans = [[Int]](repeating: [Int](repeating: 0, count: m), count: n)
        return dfs(0,0,m,n,&ans)
    }

    func dfs(_ x: Int, _ y: Int, _ m: Int, _ n: Int, _ ans: inout [[Int]]) -> Int {
        if x >= m || y >= n {
            return 0
        }
        if x == m-1 || y == n-1{
            return  1
        }

        if ans[y][x] != 0 {
            return ans[y][x]
        } 

        ans[y][x] = dfs(x+1,y,m,n,&ans) + dfs(x,y+1,m,n,&ans)
        return ans[y][x]
    }
}
// @lc code=end

