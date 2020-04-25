#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/jump-game-ii/
题目描述
45. Jump Game II
Hard
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.

Example:
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.
"""

from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        # 这个题目, 重点在于理解每一个阶段的动作
        # todo 边界情况需要考虑
        if len(nums) <= 1: return 0

        end = max_far = 0
        step = 0
        for i in range(len(nums)):
            max_far = max(max_far, i + nums[i])
            if max_far >= (len(nums) - 1):  # todo 需要写在前面, 如果可以达到末尾则返回步数
                return step + 1
            if i == end:
                step += 1
                end = max_far
        return step
