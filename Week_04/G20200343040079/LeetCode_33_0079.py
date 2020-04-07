#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/search-in-rotated-sorted-array/
题目描述
33. Search in Rotated Sorted Array
Medium
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
"""

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums: return -1

        i, j = 0, len(nums) - 1
        while i <= j:       # todo 二分查找条件一般是 i <= j
            mid = (i+j)//2
            if nums[mid] == target:
                return mid

            # 缩小范围
            if nums[mid] < nums[j]:       # todo 注意, 不是和target比较了
                if nums[mid] < target <= nums[j]:
                    i = mid + 1
                else:
                    j = mid - 1
            else:   # todo 一定要用else, 不能用elif
                if nums[i] <= target < nums[mid]:
                    j = mid - 1
                else:
                    i = mid + 1
        return -1
