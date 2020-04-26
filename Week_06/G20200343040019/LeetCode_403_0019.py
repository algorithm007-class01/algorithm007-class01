from collections import defaultdict
class Solution:
    def canCross(self, stones: List[int]) -> bool:
        N = len(stones)
        dp = defaultdict(set)
        dp[0].add(0)
        ds = [1, 0, -1]
        for i in range(N):
            for step in dp[stones[i]]:
                for j in range(3):
                    ns = step + ds[j]
                    if ns <= 0:
                        continue
                    dp[ns + stones[i]].add(ns)
        return len(dp[stones[-1]])>0
