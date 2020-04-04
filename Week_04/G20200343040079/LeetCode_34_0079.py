#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
题目描述
34. Find First and Last Position of Element in Sorted Array
Medium
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
"""

from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums: return [-1, -1]
        first = self.get_first_position(nums, target)
        last = self.get_last_position(nums, target)
        return [first, last]

    def get_first_position(self, nums, target):
        if not nums: return -1
        i, j = 0, len(nums) - 1
        while i <= j:
            mid = (i+j)//2
            if nums[mid] > target:
                j = mid - 1
            elif nums[mid] < target:
                i = mid + 1
            else:
                if mid == 0 or nums[mid-1] != target:
                    return mid
                j = mid - 1
        return -1

    def get_last_position(self, nums, target):
        if not nums: return -1
        i, j = 0, len(nums) - 1
        while i <= j:
            mid = (i+j)//2
            if nums[mid] > target:
                j = mid - 1
            elif nums[mid] < target:
                i = mid + 1
            else:
                if mid == (len(nums) - 1) or nums[mid+1] != target:
                    return mid
                i = mid + 1
        return -1
