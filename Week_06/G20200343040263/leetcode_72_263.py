# 给两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。可以对一个单词进行如下三种操作：插入一个字符；删除一个字符；替换一个字符。
# word1 = "horse", word2 = "ros" 一共三步1.horse -> rorse (将 'h' 替换为 'r')；2.rorse -> rose (删除 'r')；3.rose -> ros (删除 'e')
# 动态规划求解 
# dp[i][j]代表从word1的第i个位置到word2的第j个位置需要的最少步数
# 解释 动态规划是如何进行替换，删除，插入的操作
# 根据上面的例子，word1=horse,word2=ros,计算dp[5][3],也就是将word1的前5个字符转换为word2的三个字符
# dp[i-1][j-1] 将word1的前4个转换为word2的前2个,再将最后一个e替换为s   替换操作
# dp[i][j-1] 将word1的前5个转换为word2的前两个，最后在word1的末尾插入s
# dp[i-1][j] 将word1的前4个转换为word的前三个，最后将word1末尾的单词删除
# 状态转移方程
# if word1[i] == word2[j]: dp[i][j] = dp[i-1][j-1]
# if word1[i] != word2[j]: dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1
# 自底向上
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # 操作对象
        n1 = len(word1)
        # 目的对象
        n2 = len(word2)
        # 行是操作对象的长队，列是操作对象的长度
        dp = [[0] * (n2 + 1) for i in range(n1 + 1)]
        # dp矩阵的第一行：如果操作对象为空，则需要一直插入目的对象的每一个字符，直到是目的对象
        for j in range(1, n2 + 1):
            dp[0][j] = dp[0][j-1] + 1
        # dp矩阵的第1列，如果目的对象为空，则需要删除操作对象的每一个字符，直到为空
        for i in range(1, n1 + 1):
            dp[i][0] = dp[i-1][0] + 1
        for i in range(1, n1 + 1):
            for j in range(1, n2 + 1):
                # 状态转移方程
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
        return dp[-1][-1]