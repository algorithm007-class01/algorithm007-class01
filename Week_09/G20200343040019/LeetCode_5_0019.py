class Solution:
    def longestPalindrome(self, s: str) -> str:
        # 中心扩展
        def check(s, i, j):
            res = ""
            while i>=0 and j<len(s):
                if s[i] == s[j]:
                    res = s[i:j+1]
                    i-=1
                    j+=1
                else:                    
                    return res
            return res
        res = ""
        for i in range(len(s)):
            if len(res)>2*(len(s)-i):
                return res
            a = check(s, i, i)
            if len(a)>len(res):
                res = a 
            if i<len(s)-1:
                b = check(s, i, i+1)
                if len(b)>len(res):
                    res = b
        return res
        #todo 马拉车 maanacher