from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        cp = Counter(p)

        Lp = len(p)
        Ls = len(s)
        temp = s[:Lp]
        ct = {}
        for t in temp:
            if t in cp:
                ct[t] = 1 if t not in ct else ct[t]+1

        res = [0] if cp == ct else []
        i,j  = 0, Lp
        while j < Ls:
            pre = s[i]
            i+=1
            if pre in cp:
                ct[pre] -= 1
            last = s[j]
            j+=1
            if last in cp:
                ct[last] = 1 if last not in ct else ct[last]+1
            if ct == cp:
                res.append(i)
        return res

