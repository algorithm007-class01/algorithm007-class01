# 深度优先搜索，画树形结构图，做减法
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        cur_str = ''
        def dfs(cur_str,left,right):
            if left == 0 and right == 0:
                res.append(cur_str)
                return
            if right < left:
                return
            if left > 0:
                dfs(cur_str+'(',left-1,right)
            if right > 0:
                dfs(cur_str+')',left,right-1)
        dfs(cur_str,n,n)
        return res
# 动态规划
# 定义状态：使用i对括号可以生成的组合
# 状态转移方程：i 对括号的一个组合，在 i - 1 对括号的基础上得到，这是思考 “状态转移方程” 的基础
#        枚举的方式就是枚举左括号 "(" 和右括号 ")" 中间可能的合法的括号对数，而剩下的合法的括号对数在与第一个左括号 "(" 配对的右括号 ")" 的后面，这就用到了以前的状态。
# dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数]
# dp[i] = "(" + dp[j] + ")" + dp[i- j - 1] , j = 0, 1, ..., i - 1
# 初始状态：dp 从 0 开始，0 个括号当然就是 [""]。
from typing import List
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0: return []
        dp = [None for i in range(n+1)]
        dp[0] = ['']
        for i in range(1,n+1):
            cur = []
            for j in range(i):
                left = dp[j]
                right = dp[i-j-1]
                for s1 in left:
                    for s2 in right:
                        cur.append('('+s1+')'+s2)
            dp[i] = cur
        return dp[n]