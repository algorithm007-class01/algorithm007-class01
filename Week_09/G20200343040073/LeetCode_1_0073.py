# 387. 字符串中的第一个唯一字符
class Solution:
    def firstUniqChar(self, s: str) -> int:
        result = [0] * 26
        for c in s:
            result[ord(c) - ord('a')] += 1
        for i in range(len(s)):
            if result[ord(s[i]) - ord('a')] == 1: return i
        return -1
