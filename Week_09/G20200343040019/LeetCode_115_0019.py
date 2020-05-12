class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        if not s or not t:
            return 0
        dp = [[0 for _ in range(len(s)+1)] for _ in range(len(t)+1)]
        # dp[0][0] = 1
        for i in range(len(t)):
            for j in range(i, len(s)-len(t)+i+1):
                if i==0:
                    if s[j] == t[i]:
                        dp[i+1][j+1] = max(dp[i][:j+1])+max(dp[i+1][:j+1])+1
                elif s[j] == t[i]:
                    dp[i+1][j+1] = max(dp[i][:j+1])+max(dp[i+1][:j+1])

        return max(dp[-1])

        # 题解 
        # n1 = len(s)
        # n2 = len(t)
        # dp = [[0] * (n1 + 1) for _ in range(n2 + 1)]
        # for j in range(n1 + 1):
        #     dp[0][j] = 1
        # for i in range(1, n2 + 1):
        #     for j in range(1, n1 + 1):
        #         if t[i - 1] == s[j - 1]:
        #             dp[i][j] = dp[i - 1][j - 1]  + dp[i][j - 1]
        #         else:
        #             dp[i][j] = dp[i][j - 1]
        # #print(dp)
        # return dp[-1][-1]
