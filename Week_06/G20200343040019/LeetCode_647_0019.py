class Solution:
    def countSubstrings(self, s: str) -> int:
        res = 0
        def count(a,b):
            num = 0
            while a>=0 and b<len(s) and s[a]==s[b]:
                num+=1
                a-=1
                b+=1
            return num

        for i in range(len(s)):
            res+=count(i,i)
            res+=count(i,i+1)

        return res                                 