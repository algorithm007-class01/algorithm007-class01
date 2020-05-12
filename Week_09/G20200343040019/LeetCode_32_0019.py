class Solution:
    def longestValidParentheses(self, s: str) -> int:
        dp = [0 for _ in range(len(s)+1)]

        for i in range(1, len(s)):
            if i==1:
                if s[i-1]=="(" and s[i]==")":
                    dp[1]=2
                continue
            if s[i] == ")":
                if s[i-1] == "(":
                    dp[i] = dp[i-2] + 2
                elif s[i-1] == ")" and i-dp[i-1]-1>=0 and s[i-dp[i-1]-1] == "(":
                    dp[i] = dp[i-1]+2
                    if i-dp[i-1]-2>=0:
                        dp[i] += dp[i-dp[i-1]-2]
        
        return max(dp)