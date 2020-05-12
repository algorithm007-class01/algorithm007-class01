class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or s[0]=="0" or "00" in s:
            return 0
        
        # dp[i] = dp[i-1] if dp[i-1:] 不能拆 else dp[i-1]+1
        dp = [1 for _ in range(len(s)+1)]
        # 能拆
        for i in range(1, len(s)):
            pre, curr = int(s[i-1]), int(s[i])
            if curr == 0:
                dp[i+1] = 0
            else:
                dp[i+1] = dp[i]
            
            if pre==1 or  (pre==2 and curr<=6):
                dp[i+1] += dp[i-1]
        return dp[-1]