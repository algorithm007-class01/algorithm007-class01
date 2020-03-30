#
# @lc app=leetcode.cn id=46 lang=python
#
# [46] 全排列
#
# https://leetcode-cn.com/problems/permutations/description/
#
# algorithms
# Medium (74.46%)
# Likes:    576
# Dislikes: 0
# Total Accepted:    94.6K
# Total Submissions: 127K
# Testcase Example:  '[1,2,3]'
#
# 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
#
# 示例:
#
# 输入: [1,2,3]
# 输出:
# [
# ⁠ [1,2,3],
# ⁠ [1,3,2],
# ⁠ [2,1,3],
# ⁠ [2,3,1],
# ⁠ [3,1,2],
# ⁠ [3,2,1]
# ]
#
#

# @lc code=start
class Solution(object):
    def __init__(self):
        self.res = []

    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        tmp = []
        nums_tmp = nums[:]
        self.handle( nums,nums_tmp, tmp)
        return self.res

    def handle(self, nums, nums_tmp, tmp):
        #nums_tmp nums 剩余，从中选一
        #tmp  res 单轮 值

        if len(tmp)==len(nums):
            self.res.append(tmp[:])
            return

        for i in nums_tmp:
            tmp.append(i)
            self.handle(nums, set(nums).difference(set(tmp)), tmp)
            tmp.pop()

Solution().permute([1,2,3])
# @lc code=end

