# 字母异位词分组
# 暴力方法 按照字符的顺序sort，然后比较字符串 o(nlogn)
class solution:
    def isAnagram(self, s: str, t:str):
        return sorted(s) == sorted(t)
# 利用set函数的内置优化和特性,利用哈希表统计每个字符串的频次
class solution:
    def isAnagram(self, s: str, t:str):
        if len(s) != len(t): return: False
        se = set(s)
        if se = set(s):
            for i in se:
                if s.count(i) != s.count(i): return False
            return True
        else: return False
# 第一个单词碰到第一个字母加1，第二个单词碰到相同的字母减一，再判断map是否为空
class solution:
    def isAnagram(self, s: str, t:str):
        dic = {}
        for i in s:
            if i in dic:
                dic[i] += 1
            else: dic[i] = 1
        for i in t:
            if i not in dic or dic[i] <= 0:
                return False
            dic[i] -= 1
        for i in dic:
            if dic[i] != 0:
                return False
        return True