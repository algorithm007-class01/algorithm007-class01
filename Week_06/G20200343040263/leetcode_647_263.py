# 给定一个字符串，计算这个字符串中有多少个回文子串。具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
# "abc" 三个回文子串: "a", "b", "c". "aaa" 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        dp = [[False for i in range(n)] for j in range(n)]
        for length in range(1,n+1):
            for i in range(0,n-length+1):
                if lenght == 1:
                    dp[i][i] == True
                    res += 1
                elif lenght == 2:
                    if s[i] == s[i+1]:
                        dp[i][i+1] = True
                        res += 1
                else:
                    if s[i] == s[i+length-1] and dp[i+1][i+length-2]:
                        dp[i][i+length-1] = True
                        res += 1
        return res