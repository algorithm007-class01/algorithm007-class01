#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/find-all-anagrams-in-a-string/
题目描述
438. Find All Anagrams in a String
Medium

2479

162

Add to List

Share
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
"""

from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s or not p: return []

        from collections import defaultdict
        target = defaultdict(int)
        for ch in p:
            target[ch] += 1

        window = defaultdict(int)
        ans = []
        i = j = 0
        while j < len(s):
            if s[j] not in target:
                i = j = j + 1
                window = defaultdict(int)
            else:
                window[s[j]] += 1
                if j - i + 1 == len(p):
                    if window == target:    # todo 判断相等有疑问
                        ans.append(i)
                    window[s[i]] -= 1       # todo 减为0了还能判断么？
                    i += 1
                j += 1

        return ans
