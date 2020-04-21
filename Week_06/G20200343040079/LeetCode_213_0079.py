#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/house-robber-ii/
题目描述
213. House Robber II
Medium
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
"""

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        # 解法1 动态规划
        if len(nums) < 1: return 0
        if len(nums) <= 2: return max(nums)     # todo 还是很有必要写这个条件的, 因为输入为[1], 下面的代码会有问题

        # 将大问题分解为两个小问题, 理解它的等价性
        a1, a2 = 0, nums[0]
        b1, b2 = 0, nums[1]
        for i in range(1, len(nums)-1):  # 一次遍历
            a2, a1 = max(nums[i] + a1, a2), a2
            b2, b1 = max(nums[i+1] + b1, b2), b2
        return max(a2, b2)

        # 解法2 回溯
