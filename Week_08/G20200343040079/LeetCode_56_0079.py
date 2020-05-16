#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/merge-intervals/
题目描述
56. Merge Intervals
Medium
Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019.
Please reset to default code definition to get new method signature.
"""

from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # 解法1
        if not intervals: return []
        intervals.sort(key=lambda x: x[0])

        ans = [intervals[0]]
        for i in range(1, len(intervals)):
            # if intervals[i][0] <= ans[-1][1]:
            #     ans[-1][1] = max(ans[-1][1], intervals[i][1])
            # else:
            #     ans.append(intervals[i])

            if intervals[i][0] > ans[-1][1]:
                ans.append(intervals[i])
            elif intervals[i][1] > ans[-1][1]:
                ans[-1][1] = intervals[i][1]
        return ans
