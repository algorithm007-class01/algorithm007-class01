#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/friend-circles/
题目描述
547. Friend Circles
Medium
There are N students in a class. Some of them are friends, while some are not.
Their friendship is transitive in nature. For example, if A is a direct friend of B,
and B is a direct friend of C, then A is an indirect friend of C.
And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class.
If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
And you have to output the total number of friend circles among all the students.

Example 1:
Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
"""

from typing import List


class DisjointSet:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.count = n

    def union(self, i, j):
        p1 = self.find(i)
        p2 = self.find(j)
        if p1 != p2:
            self.parent[p1] = p2
            self.count -= 1
        return

    def find(self, i):
        root = i
        while self.parent[root] != root:
            root = self.parent[root]
        while self.parent[i] != i:  # 路径压缩
            self.parent[i], i = root, self.parent[i]
        return root


class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M: return 0

        disjoint_set = DisjointSet(len(M))
        for i in range(len(M)):
            for j in range(len(M[0])):
                if M[i][j] == 1:
                    disjoint_set.union(i, j)
        return disjoint_set.count


print(Solution().findCircleNum(
    [[1, 1, 0],
     [1, 1, 0],
     [0, 0, 1]]
))
