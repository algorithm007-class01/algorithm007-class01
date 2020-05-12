class Solution:
    def isMatch(self, s: str, p: str) -> bool:

        if p == s or p == '*':
            return True
        if p == '' or s == '':
            return False
        l1 = len(s)
        l2 = len(p)

        dp = [[0 for _ in range(l1+1)] for _ in range(l2+1)]
        dp[0][0] = 1
        for i in range(l2):
            if p[i] == "*":
                if i==0 :
                    for j in range(l1+1):
                        dp[i+1][j] = 1
                else:
                    temp = False
                    for j in range(l1+1):
                        if dp[i][j] == 1:
                            temp = True
                        dp[i+1][j] = 1 if temp else 0
            else:
                for j in range(l1):
                    if s[j] == p[i] or p[i] == "?":
                        dp[i+1][j+1] = dp[i][j]
        # print(dp)
            
        return dp[-1][-1]==1