# 不同的子序列
# 给定一个字符串s和一个zhi字符串T,计算在s的子序列中T出现的个数
# 一个字符串的一个子序列是指,通过删除一些字符且不干扰剩余字符相对位置所组成的新字符
# eg: s="rabbbit",T="rabbit" 三次,b的组合方式有三种
# eg: s="babgbag",T="bag" 五次
# 动态数组 dp[i][j] 代表T的前i字符串可以由S的j个字符串组成的个数
# 如果最后一个字符不相等,那么就需要考虑T与S的前n-1个字符
# 如果最后一个字符相等，最后T和S的最后一个都不需要考虑,只要考虑去除最后一个字符的字串
# 当S[i]=T[j],dp[i][j]=dp[i][j-1]+dp[i-1][j-1]
# 当S[j]!=T[i],dp[i][j]=dp[i][j-1]
# 初始条件,如果T是空串,S不是,那么S在T中出现的次数为0,dp[0][j]=0
#         如果S是空串,S在T中出现的次数是1，（因为T可以是空串），就是把T中的字符都删掉dp[i][0] = 1
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        n1 = len(s)
        n2 = len(t)
        dp = [[0]*(n1+1) for _ in range(n2+1)]
        for j in range(n1+1):
            dp[0][j] = 1
        for i in range(1,n2+1):
            for j in range(1,n1+1):
                if t[i-1]==s[j-1]:
                    dp[i][j] = dp[i][j-1]+dp[i-1][j-1]
                else:
                    dp[i][j] = dp[i][j-1]
        return dp[-1][-1]