class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()

        j = 0
        lj = len(g)
        while s:
            n = s.pop(0)
            if g[j]<= n:
                j+=1
                if j==lj:
                    break
        return j