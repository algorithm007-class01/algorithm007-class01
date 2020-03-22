class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        j = 0  #记录非0到达的位置
        for i in range(n):
            if nums[i]!=0:
                nums[j] = nums[i]
                if i != j:
                    nums[i] = 0
                j +=1
        return nums