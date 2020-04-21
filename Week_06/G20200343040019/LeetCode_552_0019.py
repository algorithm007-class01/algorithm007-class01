class Solution:
    def checkRecord(self, n: int) -> int:
        dp = [0 for _ in range(max(6, n+1))]
        M = 1000000007
        for i in range(n+1):
            if i<=2:
                dp[i] = 2**i
                continue
            if i<=3:
                dp[i]  = 2**i-1
                continue
            dp[i] = ((2 * dp[i - 1]) % M + (M - dp[i - 4])) % M
        
        res = dp[n]
        for i in range(1, n+1):
            res += (dp[i-1]*dp[n-i])%M
        return res%M

