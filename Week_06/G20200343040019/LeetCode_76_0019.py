from collections import Counter
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        def check(cs, ct):
            for tk, tn in ct.items():
                if tk not in cs or cs[tk]<tn:
                    return False
            return True
        cs = Counter(s)
        ct = Counter(t)
        if not check(cs, ct):
            return ""
        
        N = len(s)

        i, j = 0, len(ct.keys())
        sub = s[i:j]
        csub = Counter(sub)
        res = s
        while i<=len(s)-len(ct.keys()):
            if check(csub, ct):
                if len(sub) < len(res):
                    res = sub
                c = s[i]
                csub[c]-=1
                sub =sub[1:]
                i+=1
            elif j<len(s):
                c = s[j]
                if c in csub:
                    csub[c]+=1
                else:
                    csub[c]=1
                sub=sub+c
                j+=1
            else:
                break
        return res


            