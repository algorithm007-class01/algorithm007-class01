# -*- coding: utf-8 -*-


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        rs = []
        if not nums: return rs
        nums_dicts = {v: i for i, v in enumerate(nums)}
        for i, v in enumerate(nums):
            c = target - v
            if c in nums_dicts:
                if i == nums_dicts[c]:
                    continue
                rs = [i, nums_dicts[c]]
                nums_dicts.pop(v)
        return rs


if __name__ == '__main__':
    s = Solution()
    print(s.twoSum([-1,-2,-3,-4,-5], -8))
