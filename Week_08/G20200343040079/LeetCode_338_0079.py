#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/counting-bits/
题目描述
338. Counting Bits
Medium
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)).
But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount
in c++ or in any other language.
"""

from typing import List


class Solution:
    def countBits(self, num: int) -> List[int]:
        # # 解法1 直接计算1的个数
        # ans = []
        # for i in range(num + 1):
        #     ans.append(bin(i).count('1'))
        # return ans

        # 解法2 动态规划
        ans = [0] * (num + 1)
        for i in range(1, num + 1):
            ans[i] = ans[i & (i-1)] + 1
        return ans
