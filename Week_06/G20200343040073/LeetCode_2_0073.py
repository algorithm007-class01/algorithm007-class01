# 91. 解码方法
class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [1] * (len(s) + 2)
        for i in range(2, len(s) + 2):
            d1 = int(s[i-2:i-1])
            d2 = int(s[i-3:i-1]) if i > 2 else 0
            if d1 == 0 and d2 == 0: return 0
            dp[i] = dp[i - 1] if d1 > 0 and d1 < 27 else 0
            if d1 != d2: dp[i] += dp[i - 2] if d2 > 0 and d2 < 27 else 0
        return dp[-1]
