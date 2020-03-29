#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
42. Trapping Rain Water
Hard
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
"""


from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        # # 解法1，暴力解法，复杂度O(n^2)，Time Limit Exceeded
        # if not height: return 0
        # ans = 0
        # for i in range(1, len(height) - 1):
        #     max_left = max_right = 0
        #     j = i - 1
        #     while j >= 0:
        #         max_left = max(max_left, height[j])
        #         j -= 1
        #     j = i + 1
        #     while j < len(height):
        #         max_right = max(max_right, height[j])
        #         j += 1
        #     ans += max(0, min(max_left, max_right) - height[i])
        # return ans

        # # 解法2，动态规划，三次遍历，复杂度O(n)
        # # 加速求解一个柱子的左右两边最大值，
        # if not height: return 0
        #
        # max_left = [0] * len(height)
        # max_right = [0] * len(height)
        # for i in range(1, len(height)):
        #     max_left[i] = max(max_left[i - 1], height[i - 1])
        # for i in range(len(height) - 2, -1, -1):
        #     max_right[i] = max(max_right[i + 1], height[i + 1])
        # ans = 0
        # for i in range(len(height)):
        #     ans += max(0, min(max_left[i], max_right[i]) - height[i])
        # return ans

        # # 解法3，双指针法，两个指针向中间最大值靠拢
        # # 复杂度O(n)
        # if not height: return 0
        # i, j = 0, len(height) - 1
        # ans = max_left = max_right = 0
        # while i < j:
        #     if height[i] <= height[j]:
        #         ans += max(0, max_left - height[i])
        #         max_left = max(max_left, height[i])
        #         i += 1
        #     else:
        #         ans += max(0, max_right - height[j])
        #         max_right = max(max_right, height[j])
        #         j -= 1
        # return ans

        # # 解法4，查找最大值，以最大值index为中心，分别从左和从右向最大值方向遍历
        # # 复杂度O(n)
        # if not height: return 0
        # max_index = 0
        # for i in range(len(height)):
        #     if height[i] > height[max_index]:
        #         max_index = i
        # ans = 0
        # max_left = 0
        # for i in range(max_index):
        #     ans += max(0, max_left - height[i])
        #     max_left = max(max_left, height[i])
        # max_right = 0
        # for j in range(len(height) - 1, max_index, -1):
        #     ans += max(0, max_right - height[j])
        #     max_right = max(max_right, height[j])
        # return ans

        # stack
        # 解法5，用stack来做，stack里面的元素关心是边界变化的点
        # 这里计算面积，是上下层层计算
        if not height: return 0
        from collections import deque
        stack = deque()
        ans = 0
        for i in range(len(height)):
            while stack and height[i] > height[stack[-1]]:
                top = stack.pop()
                if not stack: break
                width = i - stack[-1] - 1
                ans += (min(height[i], height[stack[-1]]) - height[top]) * width

            stack.append(i)
        return ans
