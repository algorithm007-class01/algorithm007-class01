# -*- coding: utf-8 -*-


class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        rs = []

        def backtack(nums, tmp):
            if not nums:
                rs.append(tmp)
                return

            for i in range(len(nums)):
                backtack(nums[:i]+nums[i+1:], tmp+[nums[i]])

        backtack(nums, [])
        return rs


if __name__ == '__main__':
    s = Solution()
    print(s.permute([1, 2, 3, 4]))
