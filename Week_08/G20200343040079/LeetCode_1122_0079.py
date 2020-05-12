#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/relative-sort-array/
题目描述
1122. Relative Sort Array
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Constraints:
arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.
"""

from typing import List


class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        # # 解法1 直接排序
        # index_d = {v: i for i, v in enumerate(arr2)}
        # arr1.sort(key=lambda x: (index_d.get(x, len(index_d)), x))
        # return arr1

        # 解法2 计数排序
        length = 1001
        arr = [0] * length
        for n in arr1:
            arr[n] += 1

        ans = []
        for n in arr2:
            if arr[n] > 0:
                ans.extend([n] * arr[n])
                arr[n] = 0
        for i in range(length):
            if arr[i] > 0:
                ans.extend([i] * arr[i])
                arr[i] = 0
        return ans
