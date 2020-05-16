#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/longest-increasing-subsequence/
题目描述
300. Longest Increasing Subsequence
Medium
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
"""

from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # 解法1 动态规划, 时间复杂度O(n^2)
        if not nums: return 0

        # dp[i]定义: 包含第i个元素的最长上升子序列长度, 这个状态是可以被递推的。
        # 全局的解是由每一个最长上升子序列长度中最大的
        # todo 1. 找到可以递推的状态转移方程, 2. 全局最优解可以由每一步的最优解得到
        """
        为什么这么定义状态?
        解释：假设前 i-1 个元素的最长子上升序列是 m1, 则到第i个元素的话, 最大值是 m = max(m1, 包含第i个元素时的最长上升子序列)
        为了要计算包含第i元素的最长上升子序列长度, 需要知道前面元素的类似状态, 因此将这个状态定义为转移状态 dp
        n1 = [10,9,2,5,3,7,101], n2 = [10,9,2,5,3,7,101,18]
        f(n2) = max(f(n1), 包含18的上升子序列长度), 因此尝试将“包含18的上升子序列长度”定义为转移状态
        优先拿结果定义状态, 却发现需要定义子状态, 这个时候就把子状态定义为转移状态
        
        多用笔在纸上画画状态转移表和写写动态转移方程。自顶向下分析，自底向上求解(由小问题的解递归大问题的解)
        
        状态定义 + 转移方程 + 初始状态: 开始递推, 由递推的结果可以推导出最终需要的结果
        """
        dp = [1] * len(nums)        # todo 子序列不一定连续
        ans = dp[0]
        for i in range(1, len(nums)):
            tmp = [(dp[j] + 1) for j in range(i - 1, -1, -1) if nums[i] > nums[j]]
            if tmp: dp[i] = max(tmp)
            ans = max(ans, dp[i])
        return ans

        # 解法2 方法二：贪心 + 二分查找, 时间复杂度O(n*log n)
        pass


res = Solution().lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18])
print(res)
