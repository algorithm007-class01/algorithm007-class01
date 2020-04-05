# -*- coding: utf-8 -*-


class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """

        nums = 0
        if not isinstance(g, list) or not isinstance(s, list):
            return nums

        g.sort()
        s.sort()

        i, len_i = 0, len(g)
        j, len_j = 0, len(s)
        while i < len_i and j < len_j:
            if g[i] <= s[j]:
                nums += 1
                i += 1
            j += 1
        return nums


if __name__ == '__main__':
    s = Solution()
    print(s.findContentChildren([1,2], [1,2,3]))
