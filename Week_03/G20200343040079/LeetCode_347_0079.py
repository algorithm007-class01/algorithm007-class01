#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/top-k-frequent-elements/
347. Top K Frequent Elements
Medium
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:
Input: nums = [1], k = 1
Output: [1]
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
"""

from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # # 解法1, 统计数字出现的次数, 按照次数进行排序
        # # 时间复杂度O(nlogn)
        # from collections import Counter
        # d = Counter(nums)
        # lst = [(n, c) for n, c in d.items()]
        # lst.sort(key=lambda x: (x[1], x[0]), reverse=True)
        # return [v[0] for v in lst[:k]]

        # # 解法2 使用heapq
        # # 时间复杂度 O(nlogk)
        # import heapq
        # from collections import Counter
        # d = Counter(nums)
        # res = [v[1] for v in heapq.nlargest(k, [(c, n) for n, c in d.items()])]
        # return res

        # 解法3 使用库函数
        from collections import Counter
        d = Counter(nums)
        import heapq
        return heapq.nlargest(k, d.keys(), d.get)
