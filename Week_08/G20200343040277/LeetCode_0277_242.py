#242 有效的字母异味词
"""给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
输入: s = "anagram", t = "nagaram"
输出: true
输入: s = "rat", t = "car"
输出: false
"""

#第一种方法排序
#输入，输出。。
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        return True if sorted(s)==sorted(t) else False

    a = isAnagram(object,'ana','ana')
    print(a)


