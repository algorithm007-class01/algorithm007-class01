#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/climbing-stairs/
题目描述
70. Climbing Stairs
Easy
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
Example 1:
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
"""


class Solution:
    def climbStairs(self, n: int) -> int:
        # 解法1 迭代实现
        if n < 1: return 0
        if n == 1: return 1
        a, b = 1, 1
        for i in range(n - 1):
            a, b = b, a + b
        return b

        # 解法2 将迭代公式用矩阵相乘的形式表示, 然后用二分法加速计算
        pass
