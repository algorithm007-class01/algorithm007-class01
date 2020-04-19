#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/decode-ways/
题目描述
91. Decode Ways
Medium
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.
Example 1:
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
"""


class Solution:
    def numDecodings(self, s: str) -> int:
        # # 解法1 DFS+缓存
        # if not s: return 0
        # def _dfs(i):
        #     if i >= len(s): return 1
        #     if i in memo: return memo[i]
        #
        #     if s[i] == '0':
        #         memo[i] = 0
        #         return memo[i]
        #
        #     memo[i] = _dfs(i + 1)
        #     if i < len(s) - 1 and (s[i] == '1' or s[i] == '2' and s[i + 1] <= '6'):
        #         memo[i] += _dfs(i + 2)
        #     return memo[i]
        #
        # memo = {}
        # return _dfs(0)

        # 解法2 动态规划, dp[i] = dp[i-1] + (dp[i-2] if i与i-1合并 else 0)
        if not s or s[0] == '0': return 0
        dp = [0] * (len(s) + 1)
        dp[0] = dp[-1] = 1

        for i in range(1, len(s)):
            if s[i] == '0':
                dp[i] = dp[i - 2] if s[i - 1] in ('1', '2') else 0
            elif s[i - 1] == '1' or s[i - 1] == '2' and s[i] <= '6':
                dp[i] = dp[i - 1] + dp[i - 2]
            else:
                dp[i] = dp[i - 1]
        return dp[-2]


print(Solution().numDecodings('110'))
