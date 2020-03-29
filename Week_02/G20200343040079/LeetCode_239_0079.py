#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
239. Sliding Window Maximum
Hard
Given an array nums, there is a sliding window of size k which is moving from the very left
of the array to the very right. You can only see the k numbers in the window.
Each time the sliding window moves right by one position. Return the max sliding window.

Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
"""


from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        """最近相关性"""
        # 解法1，用stack存储遍历数字的下标
        if not nums: return []

        from collections import deque
        stack = deque()
        ans = []
        for i in range(len(nums)):
            while stack and nums[stack[-1]] < nums[i]: stack.pop()
            stack.append(i)
            if stack and i - k >= stack[0]: stack.popleft()
            if stack and i >= k - 1: ans.append(nums[stack[0]])
        return ans
