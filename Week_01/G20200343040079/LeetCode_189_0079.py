#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
189. Rotate Array
Easy
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
"""

from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # # 解法1: 空间复杂度O(n)
        # if k <= 0: return
        # count = len(nums)
        # k = k % count
        # for i, num in enumerate(nums[:]):
        #     nums[(i + k) % count] = num
        # return

        # # 解法2: 三次翻转
        # if k <= 0: return
        # n = len(nums)
        # k = k % n
        # self.reverse(nums, 0, n - k - 1)
        # self.reverse(nums, n - k, n - 1)
        # self.reverse(nums, 0, n - 1)
        # return

        # 解法2.1 三次旋转, 先大范围旋转, 再小范围旋转
        if k <= 0: return
        k %= len(nums)

        def _reverse(s, e):
            if s >= e: return
            while s < e:
                nums[s], nums[e] = nums[e], nums[s]
                s += 1
                e -= 1
            return

        _reverse(0, len(nums) - 1)
        _reverse(0, k - 1)
        _reverse(k, len(nums) - 1)
        return

    def reverse(self, nums, i, j):
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i, j = i + 1, j - 1
        return


Solution().rotate([1, 2, 3, 4, 5, 6, 7], 3)
