class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        i = 0
        for j in range(i + 1, len(nums)):

            if nums[i] ^ nums[j] != 0:
                nums[i + 1] = nums[j]
                i = i + 1
            j += 1

        return i + 1