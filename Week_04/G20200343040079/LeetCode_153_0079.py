#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
题目描述
153. Find Minimum in Rotated Sorted Array
Medium
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
"""

from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        # # 解法1
        # if not nums: return
        # i, j = 0, len(nums) - 1
        # while i <= j:           # todo 二分查找条件一般是 i <= j
        #     mid = (i+j)//2
        #     if nums[mid] > nums[j]:     # 左边有序
        #         i = mid + 1
        #     elif nums[mid] < nums[j]:   # 右边有序
        #         j = mid
        #     else:
        #         break
        # return nums[j]

        # 解法2
        if not nums: return
        i, j = 0, len(nums) - 1
        while i <= j:
            mid = (i + j) // 2
            if nums[mid] > nums[j]: # 左边有序
                i = mid + 1
            else:
                if mid == 0 or nums[mid - 1] > nums[mid]:
                    return nums[mid]
                j = mid - 1
