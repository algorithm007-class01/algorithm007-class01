#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
88. Merge Sorted Array
Easy
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n)
to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

"""


from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # “反向思考”, 从后向前合并, 时间复杂度O(m+n)
        idx = m + n - 1
        i, j = m - 1, n - 1
        while i >= 0 and j >= 0:
            if nums1[i] >= nums2[j]:
                nums1[idx] = nums1[i]
                i -= 1
            else:
                nums1[idx] = nums2[j]
                j -= 1
            idx -= 1
        while j >= 0:
            nums1[idx] = nums2[j]
            idx, j = idx - 1, j - 1
        return
