#
# @lc app=leetcode.cn id=77 lang=python
#
# [77] 组合
#
# https://leetcode-cn.com/problems/combinations/description/
#
# algorithms
# Medium (73.20%)
# Likes:    234
# Dislikes: 0
# Total Accepted:    41.4K
# Total Submissions: 56.4K
# Testcase Example:  '4\n2'
#
# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
#
# 示例:
#
# 输入: n = 4, k = 2
# 输出:
# [
# ⁠ [2,4],
# ⁠ [3,4],
# ⁠ [2,3],
# ⁠ [1,2],
# ⁠ [1,3],
# ⁠ [1,4],
# ]
#
#

# @lc code=start
class Solution(object):
    def __init__(self):
        self.res = []

    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        out = []
        self.func(1, n, k, out)
        return self.res

    def func(self, start, n, k, out):
        if len(out) == k:
            self.res.append(out[:])
            return
        for i in range(start, n + 1):
            out.append(i)
            self.func(i + 1, n, k, out)
            out.pop(-1)


Solution().combine(4, 2)
# @lc code=end

