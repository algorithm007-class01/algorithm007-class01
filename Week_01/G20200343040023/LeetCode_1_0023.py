# -*- coding: utf-8 -*-


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        j, l = 0, len(nums)

        for i in range(l-1):
            j = i + 1
            while j <= l - 1:
                if nums[i] + nums[j] == target:
                    return [i, j]
                j += 1


if __name__ == '__main__':
    s = Solution()
    print(s.twoSum([1, 3, 5, 7, 6, 4], 9))
