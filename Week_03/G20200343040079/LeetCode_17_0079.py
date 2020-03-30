#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/letter-combinations-of-a-phone-number/
题目描述
17. Letter Combinations of a Phone Number
Medium
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
"""

from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        # # 解法1 回溯
        # if not digits: return []
        # DLMAP = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        #
        # def _backtrace(digits, prefix):
        #     if not digits:
        #         ans.append(prefix)
        #         return
        #     for c in DLMAP[digits[0]]:
        #         _backtrace(digits[1:], prefix + c)
        #     return
        #
        # ans = []
        # _backtrace(digits, '')
        # return ans

        # # 解法1.1 回溯
        # if not digits: return []
        # DLMAP = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        #
        # def _backtrace(i, prefix):
        #     if i == len(digits):
        #         ans.append(prefix)
        #         return
        #     for c in DLMAP[digits[i]]:
        #         _backtrace(i+1, prefix + c)
        #     return
        #
        # ans = []
        # _backtrace(0, '')
        # return ans

        # # 解法1.2 回溯, 结果放在列表中
        # if not digits: return []
        # DLMAP = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        #
        # def _backtrace(i, s):
        #     if i == len(digits):
        #         ans.append(''.join(s))
        #         return
        #     for c in DLMAP[digits[i]]:
        #         s.append(c)
        #         _backtrace(i+1, s)
        #         s.pop()     # reverse state
        #     return
        #
        # ans = []
        # _backtrace(0, [])
        # return ans

        # # 解法2 分治
        # if not digits: return []
        # DLMAP = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        #
        # def _gen_comb(digits):
        #     if not digits: return ['']
        #     ans = []
        #     for c in DLMAP[digits[0]]:
        #         for s in _gen_comb(digits[1:]):
        #             ans.append(c+s)
        #     return ans
        #
        # ans = _gen_comb(digits)
        # return ans

        # # 解法2.1 分治
        # if not digits: return []
        # DLMAP = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        #
        # def _gen_comb(i):
        #     if i == len(digits): return ['']
        #     ans = []
        #     for c in DLMAP[digits[i]]:
        #         for s in _gen_comb(i+1):
        #             ans.append(c+s)
        #     return ans
        #
        # ans = _gen_comb(0)
        # return ans

        # 注意这两种不同的思路
        # 解法1 是遍历到终点, 添加结果数据, 每次添加一个结果
        # 解法2 是拿到子问题的结果, 然后再把当前节点的数据拼上去, 一次性返回所有结果

        # # 解法3 迭代
        # if not digits: return []
        # DLMAP = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        # res = ['']
        # for d in digits:
        #     res = [s + c for s in res for c in DLMAP[d]]
        # return res

        # 解法4 使用reduce简化操作
        if not digits: return []
        DLMAP = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        from functools import reduce
        return reduce(lambda res, d: [s + c for s in res for c in DLMAP[d]], digits, [''])


"""
方法总结:
1. 迭代: 从小累计结果, reduce简化代码

2. 递归
    a. 遍历到终点, 添加符合条件的结果
        传参方式: 引用传递, 值传递
        结束条件: 下标是否已到, 值是否为空
    b. 返回子问题的结果, 拼接成更大的结果
    
"""


res = Solution().letterCombinations('23')
print(res)
