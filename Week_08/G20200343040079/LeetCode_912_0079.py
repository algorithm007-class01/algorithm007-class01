#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode-cn.com/problems/sort-an-array/
题目描述
912. 排序数组
给你一个整数数组 nums，请你将该数组升序排列。
示例 1：
输入：nums = [5,2,3,1]
输出：[1,2,3,5]
示例 2：
输入：nums = [5,1,1,2,0,0]
输出：[0,0,1,1,2,5]
提示：
1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000
"""

from typing import List
from random import randint


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        if len(nums) <= 1: return nums
        self._sort(nums, 0, len(nums) - 1)
        return nums

    def _sort(self, nums, start, end):
        if start >= end: return
        index = self._partition(nums, start, end)
        self._sort(nums, start, index - 1)
        self._sort(nums, index + 1, end)
        return

    def _partition(self, nums, start, end):
        """分区函数 LR"""
        if start >= end: return start
        pivot = randint(start, end)
        nums[pivot], nums[end] = nums[end], nums[pivot]
        i, j = start, end
        while i < j:
            while i < j and nums[i] < nums[end]:
                i += 1
            while i < j and nums[j] >= nums[end]:
                j -= 1
            if i < j: nums[i], nums[j] = nums[j], nums[i]
        nums[end], nums[i] = nums[i], nums[end]
        return i

    def _partition1(self, nums, start, end):
        """分区函数 LL"""
        if start >= end: return start
        pivot = randint(start, end)
        nums[pivot], nums[end] = nums[end], nums[pivot]
        pivot = nums[end]
        for i in range(start, end + 1):
            if nums[i] > pivot:
                pass
            else:
                nums[i], nums[start] = nums[start], nums[i]
                start += 1
        return start - 1

    def _partition2(self, nums, start, end):
        """分区函数 LL"""
        if start >= end: return start
        from random import randint
        index = randint(start, end)
        nums[index], nums[end] = nums[end], nums[index]

        for i in range(start, end):
            if nums[i] < nums[end]:
                nums[i], nums[start] = nums[start], nums[i]
                start += 1
        nums[start], nums[end] = nums[end], nums[start]
        return start

    def mergeSort(self, nums: List[int]) -> List[int]:
        if len(nums) <= 1: return nums

        mid = len(nums) // 2
        left = self.mergeSort(nums[:mid])
        right = self.mergeSort(nums[mid:])
        return self._merge(left, right)

    def _merge(self, left, right):
        if not left or not right: return left or right
        i, j = 0, 0
        ans = []
        while i < len(left) and j < len(right):
            if left[i] <= right[j]:
                ans.append(left[i])
                i += 1
            else:
                ans.append(right[j])
                j += 1
        ans.extend(left[i:] + right[j:])
        return ans


print(Solution().mergeSort([5, 1, 1, 2, 0, 0]))
