# -*- coding: utf-8 -*-


class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        rs = []

        def backtrack(i, k, tmp):
            if k == 0:
                rs.append(tmp)
                return

            for j in range(i, n+1):
                backtrack(j+1, k-1, tmp + [j])

        backtrack(1, k, [])
        return rs


if __name__ == '__main__':
    s = Solution()
    rs = s.combine(4, 2)
    for i in rs:
        print(i)
