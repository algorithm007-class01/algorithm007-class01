# -*- coding: utf-8 -*-


class Solution(object):
    def climbStairs(self , n):
        """
        :type n: int
        :rtype: int
        """

        if n < 1:
            return 0
        elif n < 3:
            return n

        a1, a2, tmp = 1, 2, 0

        for i in range(n - 2):
            tmp = a1 + a2
            a1 = a2
            a2 = tmp

        return tmp
