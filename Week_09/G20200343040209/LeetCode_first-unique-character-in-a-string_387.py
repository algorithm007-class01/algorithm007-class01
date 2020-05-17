class Solution3(object):

    def firstUniqChar(self, s: str) -> int:
        dic = {}

        # 记录字符出现次数
        for c in s:
            dic[c] = dic[c] + 1 if c in dic else 1

        # 过滤出现次数不为一的字符
        unique_chars = [k for k, v in filter(lambda kvp: kvp[1] == 1, dic.items())]
        # 遍历目标字符串，返回首个出现在unique_chars中的字符的索引
        for i, c in enumerate(s):
            if c in unique_chars:
                return i

        return -1