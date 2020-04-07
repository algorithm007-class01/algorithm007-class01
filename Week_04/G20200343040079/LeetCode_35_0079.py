#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/search-insert-position/
题目描述
35. Search Insert Position
Easy
Given a sorted array and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Example 1:
Input: [1,3,5,6], 5
Output: 2

Example 2:
Input: [1,3,5,6], 2
Output: 1

Example 3:
Input: [1,3,5,6], 7
Output: 4

Example 4:
Input: [1,3,5,6], 0
Output: 0
"""

from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        """查找第一个大于等于target的值"""
        if not nums: return

        i, j = 0, len(nums) - 1
        while i <= j:           # todo 寻找第一个大于等于target的值
            mid = (i + j) // 2
            if nums[mid] >= target:
                if mid == 0 or nums[mid - 1] < target:
                    return mid
                j = mid - 1
            else:
                i = mid + 1
        return i
