class Solution:
    def countSubstrings(self, s: str) -> int:
        length = len(s)
        if length < 2: return length
        dp = [[0 for _ in range(length)] for _ in range(length)]
        res = 0
        for r in range(length):
            for l in range(r + 1):
                if r == l:
                    dp[l][r] = 1
                    res += 1
                elif s[l] == s[r] and (r - l <= 2 or dp[l + 1][r - 1]):
                    dp[l][r] = 1
                    res += 1
        return res