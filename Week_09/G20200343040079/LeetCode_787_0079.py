#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/cheapest-flights-within-k-stops/
题目描述
787. Cheapest Flights Within K Stops
Medium
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst,
your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph looks like this:
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph looks like this:

The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
Note:
The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.
"""

from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        # # 解法1 DFS深度优先遍历
        # from collections import defaultdict
        # f = defaultdict(dict)
        # for a, b, p in flights:
        #     f[a][b] = p  # 城市之间的距离
        #
        # def _dfs(src, k, dist):
        #     nonlocal ans
        #     if src == dst:
        #         ans = min(ans, dist)
        #         return
        #     if k < 0: return
        #
        #     for d in f[src]:
        #         if d in visited: continue            # // todo do not visit the same city twice.剪枝, 否则不通过
        #         if dist + f[src][d] > ans: continue  # // todo IMPORTANT!!! prunning, 剪枝, 否则不通过
        #
        #         visited.add(d)
        #         _dfs(d, k - 1, dist + f[src][d])
        #         visited.remove(d)
        #     return
        #
        # ans = float('inf')
        # visited = set()
        # visited.add(src)
        # _dfs(src, K, 0)
        # return -1 if ans >= float('inf') else ans

        # # 解法2 BFS广度优先遍历
        # from collections import defaultdict
        # f = defaultdict(dict)
        # for a, b, p in flights:
        #     f[a][b] = p
        #
        # ans = float('inf')
        # k = 0
        # from collections import deque
        # q = deque([(src, 0)])
        # while q:
        #     for _ in range(len(q)):
        #         s, distance = q.popleft()
        #         if s == dst:
        #             ans = min(ans, distance)
        #             continue
        #         for p in f[s]:
        #             if distance + f[s][p] > ans: continue       # todo IMPORTANT prunning 剪枝
        #             q.append((p, distance + f[s][p]))
        #     if k > K: break
        #     k += 1
        # return -1 if ans >= float('inf') else ans

        # 解法3 动态规划, Bellman-Ford algorithm
        # todo 将一次转机作为动作转移
        # todo 问题分析是关键, 动作是飞行
        # 动态规划
        dp = [float('inf')] * n
        dp[src] = 0
        for _ in range(K + 1):
            tmp = dp[:]
            for u, v, c in flights:
                dp[v] = min(dp[v], tmp[u] + c)      # todo 注意min里面, 转机是从tmp过来的
        return -1 if dp[dst] == float('inf') else dp[dst]

        # # 解法4 Dijkstra算法
        # from collections import defaultdict
        # f = defaultdict(dict)
        # for u, v, d in flights:
        #     f[u][v] = d
        #
        # import heapq
        # heap = [(0, src, K)]
        # while heap:
        #     distance, u, k = heapq.heappop(heap)
        #     if u == dst: return distance
        #
        #     if k >= 0:
        #         for v, d in f[u].items():
        #             heapq.heappush(heap, (distance + d, v, k - 1))
        # return -1


print(Solution().findCheapestPrice(3, [[0, 1, 100], [1, 2, 100], [0, 2, 500]], 0, 2, 1))
