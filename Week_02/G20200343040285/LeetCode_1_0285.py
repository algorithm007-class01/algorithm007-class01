#
# @lc app=leetcode.cn id=1 lang=python
#
# [1] 两数之和
#

# @lc code=start
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = {}
        for i, i_data in enumerate(nums):
            j = map.get(target - i_data)
            if j is not None or j != i:
                return [i, j]
            map[i_data] = i
        return []

      
ins = Solution()
nums = [2,7,11,15]
target = 9
res = ins.twoSum(nums, target) 
# print(res)  
# @lc code=end

