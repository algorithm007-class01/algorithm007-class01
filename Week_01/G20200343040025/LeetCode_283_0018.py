"""
283.移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
"""
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        if not nums:
            return 0
        j=0
        for i in range(n):
            if nums[i]:
                nums[j],nums[i]=nums[i],nums[j]
                j=j+1

