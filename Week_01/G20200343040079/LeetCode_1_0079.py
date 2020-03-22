#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
1. Two Sum
Easy
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
"""


from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """代码解答思路，及复杂度说明"""
        # 解法1, brute force 暴力求解 O(n^2)
        # for i in range(len(nums)-1):
        #     for j in range(i+1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]
        # return [-1, -1]

        # 解法2, 空间换时间, 用hash表标记访问过的元素, 时间复杂度O(n), 空间复杂度O(n)
        s = {}
        for i, n in enumerate(nums):
            x = target-n
            if x in s:
                return [s[x], i]
            s[n] = i
        return [-1, -1]
