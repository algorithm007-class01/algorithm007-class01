class Solution:
    def numDecodings(self, s: str) -> int:    
        dp = [0  for _ in range(len(s))]
        if s[0] == "0": return 0
        dp[0] = 1
        if len(s) < 2:
            return dp[0]
        if s[1] == "0":
            if int(s[0]) < 3: dp[1] = 1
            else:  return 0
        else:
            if int(s[0:2]) <= 26: dp[1] = 2
            else: dp[1] = 1
        for i in range(2, len(s)):
            if s[i] == "0":
                if int(s[i-1]) > 2 or s[i-1] == "0": return 0
                elif int(s[i-1]) < 3: dp[i] = dp[i-2]
            elif 10 < int(s[i-1]+s[i]) < 27: dp[i] = dp[i-1] + dp[i-2]
            else: dp[i] = dp[i-1]
        return dp[-1]