# -*- coding: utf-8 -*-


class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        rs = []
        nums.sort()

        def backtrack(nums, tmp):
            if not nums:
                rs.append(tmp)
                return

            for i in range(len(nums)):
                if i > 0 and nums[i] == nums[i-1]:
                    continue
                backtrack(nums[:i]+nums[i+1:], tmp+[nums[i]])
        backtrack(nums, [])
        return rs


if __name__ == '__main__':
    s = Solution()
    print(s.permuteUnique([3,3,0,3]))
