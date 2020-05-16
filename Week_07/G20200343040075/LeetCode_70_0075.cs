/*
 * @lc app=leetcode.cn id=70 lang=csharp
 *
 * [70] 爬楼梯
 */

// @lc code=start
public class Solution {
    public int ClimbStairs(int n) {
        if (n <= 2)
            return n;

        // faci数列 f(n) = f(n - 1) + f(n - 2)
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        for (int i = 3; i < n; i++)
        {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        return f3;
    }
}
// @lc code=end

