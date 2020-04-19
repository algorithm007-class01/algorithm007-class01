#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
题目描述
154. Find Minimum in Rotated Sorted Array II
Hard
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.
The array may contain duplicates.
Example 1:
Input: [1,3,5]
Output: 1
Example 2:
Input: [2,2,2,0,1]
Output: 0
Note:
This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
"""

from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums: return

        i, j = 0, len(nums) - 1
        while i <= j:           # todo 二分查找条件一般是 i <= j
            mid = (i + j) // 2

            # todo 这个判断很重要, 是退出循环的条件
            if mid == j: break

            if nums[mid] > nums[j]:  # 左边有序
                i = mid + 1
            elif nums[mid] < nums[j]:  # 右边有序
                j = mid
            else:
                j -= 1
        return nums[j]
