#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
66. Plus One
Easy
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list,
and each element in the array contain a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
"""


from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        # carry初始值为1, 表示加1
        carry, res = 1, []
        for i in range(len(digits)-1, -1, -1):
            carry, mod = divmod(carry + digits[i], 10)
            res.insert(0, mod)
        if carry: res.insert(0, carry)
        return res
