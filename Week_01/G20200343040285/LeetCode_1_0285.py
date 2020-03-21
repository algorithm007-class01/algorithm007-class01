class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        res = []

        for i, i_data in enumerate(nums):
            j = target - i_data
            if j not in nums:
                continue
            elif nums.index(j) == i:
                continue
            elif i not in res:
                res.extend([i, nums.index(j)])
        return res


ins = Solution()
nums = [2, 7, 11, 15]
target = 9
res = ins.twoSum(nums, target)