#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/minimum-genetic-mutation/
题目描述
433. Minimum Genetic Mutation
Medium
A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
Suppose we need to investigate about a mutation (mutation from "start" to "end"),
where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
Also, there is a given gene "bank", which records all the valid gene mutations.
A gene must be in the bank to make it a valid gene string.
Now, given 3 things - start, end, bank, your task is to determine what is the minimum
number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:
Starting point is assumed to be valid, so it might not be included in the bank.
If multiple mutations are needed, all mutations during in the sequence must be valid.
You may assume start and end string is not the same.


Example 1:
start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]
return: 1


Example 2:
start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
return: 2


Example 3:
start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
return: 3
"""

from typing import List


class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        # # 解法1 广度优先BFS遍历
        # if not start or not end or not bank or len(start) != len(end): return -1
        #
        # bank = set(bank)
        # from collections import deque
        # q = deque([start])
        # cnt = 0
        # while q:
        #     for _ in range(len(q)):
        #         s = q.popleft()
        #         if s == end: return cnt
        #         for i in range(len(s)):
        #             for c in ['A', 'C', 'G', 'T']:
        #                 s1 = s[:i] + c + s[i + 1:]
        #                 if s1 in bank:
        #                     q.append(s1)
        #                     bank.remove(s1)
        #     cnt += 1
        # return -1

        # # 解法1.1
        # if not bank or end not in bank: return -1
        # from collections import defaultdict
        # # 生成commb
        # commb = defaultdict(list)
        # for s in bank:
        #     for i in range(len(s)):
        #         commb[s[:i] + '*' + s[i + 1:]].append(s)
        # from collections import deque
        # queue = deque([start])
        # level = 0
        # while queue:
        #     for _ in range(len(queue)):
        #         s = queue.popleft()
        #         if s == end: return level
        #         for i in range(len(s)):
        #             new = s[:i] + '*' + s[i + 1:]
        #             queue.extend(commb[new])
        #             commb[new] = []     # remove遍历过的元素
        #     level += 1
        # return -1

        # # 解法2 深度优先遍历DFS
        # # 有 bug, 超时跑不出来结果
        #
        # if not start or not end or not bank or len(start) != len(end): return -1
        #
        # bank = set(bank)
        # if end not in bank: return -1
        #
        # def _dfs(cnt, start):
        #     if start == end:
        #         nonlocal ans
        #         ans = min(ans, cnt) if ans != -1 else cnt
        #         return
        #     for i in range(len(start)):
        #         for c in ['A', 'C', 'G', 'T']:
        #             new = start[:i] + c + start[i+1:]
        #             if new in bank:
        #                 bank.remove(new)        # todo 去重很重要
        #                 _dfs((cnt + 1) if start[i] != c else cnt, new)  # todo 次数变换注意
        #     return
        # ans = -1
        # _dfs(0, start)
        # return ans

        # 解法3 two-end BFS, 双向BFS
        if not bank: return -1
        bank = set(bank)
        if end not in bank: return -1

        f, b = {start}, {end}
        level = 1
        while f:
            new_f = set()
            for s in f:
                for i in range(len(s)):
                    for ch in ['A', 'C', 'G', 'T']:
                        new_s = s[:i] + ch + s[i+1:]
                        if new_s in b:
                            return level
                        if new_s in bank:
                            new_f.add(new_s)
                            bank.remove(new_s)
            f = new_f
            level += 1
            if len(f) > len(b):
                f, b = b, f
        return -1



res = Solution().minMutation("AAAAACCC", "AACCCCCC", ["AAAACCCC", "AAACCCCC", "AACCCCCC"])
print(res)
