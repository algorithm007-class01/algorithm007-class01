"""
解码方法

一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [1] * (len(s) + 2)
        for i in range(2, len(s) + 2):
            d1 = int(s[i-2:i-1])
            d2 = int(s[i-3:i-1]) if i > 2 else 0
            if d1 == 0 and d2 == 0: return 0
            dp[i] = dp[i - 1] if d1 > 0 and d1 < 27 else 0
            if d1 != d2: dp[i] += dp[i - 2] if d2 > 0 and d2 < 27 else 0
        return dp[-1]