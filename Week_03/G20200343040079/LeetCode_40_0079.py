#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
题目描述
面试题40. 最小的k个数
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

示例 1：
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]
限制：
0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000
"""

from typing import List
from random import randint


class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        # # 解法1 先排序, 取前k个数
        # # 复杂度 O(nlogn)
        # arr.sort()
        # return arr[:k]

        # # 解法2 用堆heapq直接获取最小的k个数
        # # 复杂度 O(nlogk)
        # import heapq
        # return heapq.nsmallest(k, arr)

        # # 解法3 利用快速排序思想
        # # 复杂度 O(n)
        # if not arr or k <= 0: return []
        # if k >= len(arr): return arr
        #
        # def _partition(arr, start, end):
        #     if start >= end: return start
        #     for i in range(start, end):
        #         if arr[i] < arr[end]:
        #             arr[start], arr[i] = arr[i], arr[start]
        #             start += 1
        #     arr[start], arr[end] = arr[end], arr[start]
        #     return start
        # start, end = 0, len(arr) - 1
        # while True:
        #     index = _partition(arr, start, end)
        #     if index == k - 1:
        #         break
        #     elif index > k - 1:
        #         end = index - 1
        #     elif index < k - 1:
        #         start = index + 1
        # return arr[:k]

        # 解法4 快速排序的另一种实现
        if k <= 0: return []
        if k >= len(arr): return arr

        def _partition(start, end):
            if start >= end: return start   # todo 注意 return start
            pivot = randint(start, end)
            arr[end], arr[pivot] = arr[pivot], arr[end]
            i, j = start, end   # TODO  注意 i j 的初始值设置
            # todo 如何验证 i j下标对不对呢？那就假定有一个数据、两个数据、三个数据的情况是否正常
            #  测试以上三种情况下的各种数据, 如两个数前大后小, 前小后大, 两个相等等
            while i < j:
                while i < j and arr[i] < arr[end]: i += 1
                while i < j and arr[j] >= arr[end]: j -= 1
                if i < j: arr[i], arr[j] = arr[j], arr[i]
            arr[i], arr[end] = arr[end], arr[i]
            return i

        start, end = 0, len(arr) - 1
        while True:
            index = _partition(start, end)
            if index == k - 1:
                return arr[:k]
            elif index > k - 1:
                end = index - 1
            else:
                start = index + 1
        return arr[:k]
