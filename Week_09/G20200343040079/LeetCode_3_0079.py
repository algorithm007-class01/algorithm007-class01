#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/longest-substring-without-repeating-characters/
题目描述
3. Longest Substring Without Repeating Characters
Medium
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # 解法1 动态规划
        # if not s: return 0
        # dp = [0] * len(s)
        # d = {}
        # ans = 0
        # for i, ch in enumerate(s):
        #     if ch not in d:
        #         dp[i] = dp[i-1] + 1
        #     else:
        #         dp[i] = min(i - d[ch], dp[i-1] + 1)
        #     d[ch] = i
        #     ans = max(ans, dp[i])
        # return ans

        # 解法2 “滑动窗口”法, 双指针
        if not s: return 0
        l, r = 0, 0
        visited = set()
        ans = 0
        while r < len(s):
            while r < len(s) and s[r] not in visited:
                visited.add(s[r])
                r += 1

            ans = max(ans, r - l)
            # 左指针移动
            visited.remove(s[l])
            l += 1
        return ans
