# 爬楼梯问题
# 动态规划
class Solution:
    def climbStairs(self, n: int):
        i = 1
        j = 2
        for q in range(3,n):
            i, j = j, i+j
        return i + j if n > 2 else n
# 递归方法
class Solution:
    @functools.lru_cache(None)
    def climbStairs(self, n: int):
        if n <= 2: return n
        return self.climbStairs(n-1) + self.climbStairs(n-2)