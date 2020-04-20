# -*- coding: utf-8 -*-


class Solution(object):

    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        non_zore = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[non_zore], nums[i] = nums[i], nums[non_zore]
                non_zore += 1
