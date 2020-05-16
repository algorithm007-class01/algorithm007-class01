# -*- coding: utf-8 -*-


class Solution:
    def findCircleNum(self, M):
        n = len(M)
        p = {i: {i} for i in range(n)}
        ans = n
        for i in range(n):
            for j in range(i, n):
                if M[i][j] == 1 and p[i] is not p[j]:
                    p[i] |= p[j]
                    for k in p[j]:
                        p[k] = p[i]
                    ans -= 1
        return ans
