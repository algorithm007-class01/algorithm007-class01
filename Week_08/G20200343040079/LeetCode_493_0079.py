#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/reverse-pairs/
题目描述
493. Reverse Pairs
Hard
Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.
"""


class Solution:
    def reversePairs(self, nums: List[int]) -> int:
        # # 解法1 超时
        # if not nums: return 0
        # ans = 0
        # for i in range(len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] > 2*nums[j]:
        #             ans += 1
        # return ans

        # 解法2 归并排序
        if not nums: return 0

        self.ans = 0
        self.merge_sort(nums)
        return self.ans

    def merge_sort(self, nums):
        if not nums: return []
        if len(nums) <= 1: return nums

        def _merge(left, right):
            if not left or not right: return left or right

            i, j = 0, 0
            arr = []
            while i < len(left) and j < len(right):
                if left[i] <= right[j]:
                    arr.append(left[i])
                    i += 1
                else:
                    arr.append(right[j])
                    j += 1
            arr.extend(left[i:] + right[j:])
            return arr

        mid = len(nums) // 2
        left = self.merge_sort(nums[:mid])
        right = self.merge_sort(nums[mid:])

        # 计算逆序数
        j = len(right) - 1
        for i in range(len(left) - 1, -1, -1):
            while j >= 0 and left[i] <= 2 * right[j]:
                j -= 1
            self.ans += (j + 1)
        return _merge(left, right)
