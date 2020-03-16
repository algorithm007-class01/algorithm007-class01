#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
283. Move Zeroes
Easy
Given an array nums, write a function to move all 0's to the end of it while maintaining the
relative order of the non-zero elements.
Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
"""


from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # # 解法1, 一次遍历法, 最后设置0
        # # 参数检查
        # if not nums:return
        # z = 0
        # for i in range(len(nums)):
        #     if nums[i]:
        #         nums[z] = nums[i]
        #         z += 1
        # for i in range(z, len(nums)):
        #     nums[i] = 0
        # return
        #
        # # 解法2, 基于解法1简单优化
        # z = 0
        # for i in range(len(nums)):
        #     if nums[i]:
        #         nums[z] = nums[i]
        #         if i != z: nums[i] = 0
        #         z += 1
        # return

        # 解法3, 交换两个数
        z = 0
        for i in range(len(nums)):
            if nums[i]:
                nums[z], nums[i] = nums[i], nums[z]
                z += 1
        return
