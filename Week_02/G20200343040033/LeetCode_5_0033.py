from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic=dict()
        for i,value in enumerate(nums):
            if dic.get(target-value)==None:
                dic[value]=i
            else:
                return [i,dic[target-value]]