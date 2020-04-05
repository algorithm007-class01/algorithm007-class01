#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/generate-parentheses/
题目描述
169. Majority Element
Easy
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2
"""

from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # # 解法1 排序
        # nums.sort()
        # return nums[len(nums)//2]

        # # 解法2 统计次数, 空间复杂度O(n), 时间复杂度O(n)
        # d = {}
        # half = len(nums) // 2 + len(nums) % 2
        # for n in nums:
        #     d[n] = d.get(n, 0) + 1
        #     if d[n] >= half:
        #         return n

        # 解法3 另类计数法, 时间复杂度O(n)
        major, count = 0, 0
        for n in nums:
            if count == 0:
                major = n
                count = 1
            elif n == major:
                count += 1
            else:
                count -= 1
        return major
