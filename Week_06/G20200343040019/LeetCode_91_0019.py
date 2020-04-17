class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or s[0]=="0" or "00" in s:
            return 0
        
        dp = [1 for _ in range(len(s)+1)]
        for i in range(len(s)):
            if s[i] == "0":
                dp[i+1] = 0
            else:
                dp[i+1] = dp[i]
              
            if i>0 and 10<=int(s[i-1:i+1])<=26:
                dp[i+1] += dp[i-1]
        # print(dp)
        return dp[-1]