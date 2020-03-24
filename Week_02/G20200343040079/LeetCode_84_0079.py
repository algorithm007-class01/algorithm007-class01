#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
84. Largest Rectangle in Histogram
Hard
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram.

Example:
Input: [2,1,5,6,2,3]
Output: 10
"""


from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # # 解法1，暴力解法  Time Limit Exceeded
        # if not heights: return 0
        # ans = 0
        # for i in range(len(heights)):
        #     left_bound = i - 1
        #     right_bound = i + 1
        #     while left_bound >= 0 and heights[left_bound] >= heights[i]:
        #         left_bound -= 1
        #     while right_bound <= len(heights)-1 and heights[right_bound] >= heights[i]:
        #         right_bound += 1
        #     ans = max(ans, (right_bound - left_bound - 1)*heights[i])
        # return ans

        # 解法2，stack
        # 栈中元素从小到大排列，目的为了可以直接获取到当前栈顶元素的左右边界
        if not heights: return 0
        from collections import deque
        stack = deque([-1])
        heights.append(0)
        ans = 0
        for i in range(len(heights)):
            while heights[i] < heights[stack[-1]]:
                top = stack.pop()
                width = i - stack[-1] - 1
                ans = max(ans, heights[top] * width)
            stack.append(i)
        return ans
