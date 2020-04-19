#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/task-scheduler/
题目描述
621. Task Scheduler
Medium
Given a char array representing tasks CPU need to do. It contains capital letters A to Z
where different letters represent different tasks. Tasks could be done without original order.
Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks,
there must be at least n intervals that CPU are doing different tasks or just be idle.
You need to return the least number of intervals the CPU will take to finish all the given tasks.
Example:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Constraints:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
"""

from typing import List


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:

        # 解法1 每个轮次内, 安排数量最多的n个任务
        if not tasks: return 0
        import heapq
        h = []
        from collections import Counter
        d = Counter(tasks)
        for k, v in d.items():
            heapq.heappush(h, (-v, k))

        time = 0
        while h:
            i = 0
            tmp = []
            while h and i < n + 1:
                v, k = heapq.heappop(h)
                if v < -1:
                    tmp.append((v + 1, k))
                i += 1
            for t in tmp:
                heapq.heappush(h, t)
            time += (n + 1 if h else i)
        return time


print(Solution().leastInterval(["A", "A", "A", "B", "B", "B"], 2))
