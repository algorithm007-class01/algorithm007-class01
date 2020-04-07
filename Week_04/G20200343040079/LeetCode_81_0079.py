#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
题目描述
81. Search in Rotated Sorted Array II
Medium
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
"""

from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        if not nums: return False

        i, j = 0, len(nums) - 1
        while i <= j:       # todo 二分查找条件一般是 i <= j
            mid = (i+j)//2
            if nums[mid] == target:
                return True

            # 缩小范围
            if nums[mid] < nums[j]:     # 右边有序
                if nums[mid] < target <= nums[j]:
                    i = mid + 1
                else:
                    j = mid - 1
            elif nums[mid] > nums[j]:   # 左边有序
                if nums[i] <= target < nums[mid]:
                    j = mid - 1
                else:
                    i = mid + 1
            else:       # 范围缩小1, 时间复杂度退化为O(n)
                j -= 1
        return False
